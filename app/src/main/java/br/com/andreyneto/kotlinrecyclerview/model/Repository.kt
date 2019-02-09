package br.com.andreyneto.kotlinrecyclerview.model

data class Repository(
    val id: Long?,
    val name: String?,
    val full_name: String?,
    val owner: Owner?,
    val html_url: String?,
    val description: String?)