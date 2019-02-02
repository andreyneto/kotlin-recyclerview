package br.com.andreyneto.kotlinrecyclerview.model

import androidx.annotation.DrawableRes

data class ProgrammingLanguage(
    @DrawableRes
    val imageResourceId: Int,
    val title: String,
    val year: Int,
    val description: String)