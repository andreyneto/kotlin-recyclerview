package br.com.andreyneto.kotlinrecyclerview.model

import com.google.gson.annotations.SerializedName

data class GitHubRepositoriesResult(
    @SerializedName("itens")
    val repositories: List<Repository>
)