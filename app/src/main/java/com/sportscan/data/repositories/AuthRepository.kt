package com.sportscan.data.repositories

import com.sportscan.data.local.LocalAuthManager
import com.sportscan.data.local.dao.UsersDao
import com.sportscan.data.local.entitys.Users
import com.sportscan.utils.ResultData

class AuthRepository(
    private val usersDao: UsersDao,
    private val localAuthManager: LocalAuthManager
) {

    suspend fun login(email: String, password: String): ResultData {
        val user = usersDao.loginUser(email, password)
        return if (user != null) {
            localAuthManager.rememberAuth(user.email, user.password)
            ResultData.Success(user)
        } else {
            ResultData.Error<Unit>("User not found")
        }
    }

    suspend fun signUp(email: String, password: String): ResultData {
        if (usersDao.getUserByEmail(email) != null)
            return ResultData.Error<Unit>("User has already exists")
        val users = Users(
            id = 0,
            email = email,
            password = password
        )
        usersDao.upsertUser(users)
        localAuthManager.rememberAuth(email, password)
        return ResultData.Success<Unit>()

    }
}