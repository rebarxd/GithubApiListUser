package com.example.githubappapitest.data.remote

import com.example.githubappapitest.data.model.ResponeUserGithub
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface GithubService {

    @JvmSuppressWildcards
    @GET("users")
    suspend fun getUserGithub():MutableList<ResponeUserGithub.Item>
}