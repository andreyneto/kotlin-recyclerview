package br.com.andreyneto.kotlinrecyclerview.api

import br.com.andreyneto.kotlinrecyclerview.model.GitHubRepositoriesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {
    @GET("search/repositories")
    fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc") : Call<GitHubRepositoriesResult>
}