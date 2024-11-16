package com.sportscan.data.repositories

import com.sportscan.data.local.dao.UsersDao
import com.sportscan.data.local.entitys.Users
import com.sportscan.utils.ResultData
import javax.inject.Inject

class AuthRepository @Inject constructor(private val usersDao: UsersDao) {

    suspend fun authUser(email: String, password: String): ResultData {
        val user = usersDao.loginUser(email, password)
        return if (user != null) {
            ResultData.Success(user)
        } else {
            ResultData.Error<Unit>("User not found")
        }
    }

    suspend fun signUpUser(email: String, password: String): ResultData {
        if (usersDao.getUserByEmail(email) != null)
            return ResultData.Error<Unit>("User has already exists")
        val users = Users(
            id = 0,
            email = email,
            password = password
        )
        usersDao.upsertUser(users)
        return ResultData.Success<Unit>()

    }
}