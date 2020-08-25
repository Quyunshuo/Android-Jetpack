package com.quyunshuo.hilt.testclass

import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{user}")
    suspend fun getGitHubUserInfo(@Path("user") userName: String): GitHubUserData
}