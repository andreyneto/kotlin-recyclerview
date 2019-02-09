package br.com.andreyneto.kotlinrecyclerview.api

import br.com.andreyneto.kotlinrecyclerview.model.GitHubRepositoriesResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRetriever {
    private val service: GitHubService

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create())
            .build()
        service = retrofit.create(GitHubService::class.java)
    }

    fun getLanguageRepositories(callback: Callback<GitHubRepositoriesResult>,
                                query: String) {
        val call = service.searchRepositories("language:$query")
        call.enqueue(callback)
    }
}
