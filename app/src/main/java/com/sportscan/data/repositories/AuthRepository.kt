package com.sportscan.data.repositories

import com.sportscan.data.local.DataStoreManager
import com.sportscan.data.local.dao.UsersDao
import com.sportscan.data.local.entitys.Users
import com.sportscan.utils.ResultData

class AuthRepository(
    private val usersDao: UsersDao,
    private val dataStoreManager: DataStoreManager
) {

    suspend fun login(email: String, password: String): ResultData {
        val user = usersDao.loginUser(email, password)
        return if (user != null) {
            dataStoreManager.saveToken(user.email, user.password) // Assuming you want to save the user ID as the token
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
        dataStoreManager.saveToken(email, password)
        return ResultData.Success<Unit>()

    }
}