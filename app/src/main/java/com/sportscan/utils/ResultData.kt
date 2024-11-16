package com.sportscan.utils

sealed class ResultData {
    data class Success<T>(val data: T? = null) : ResultData()
    data class Error<T>(val msg: String = "", val data: T? = null) : ResultData()
}