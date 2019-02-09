package br.com.andreyneto.kotlinrecyclerview.api

import retrofit2.Call
import retrofit2.http.Query

interface GitHubService {
    fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc") : Call<GitHubRepositoriesResult>
}