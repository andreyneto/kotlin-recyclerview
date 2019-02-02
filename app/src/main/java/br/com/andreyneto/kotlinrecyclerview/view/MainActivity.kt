package br.com.andreyneto.kotlinrecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.andreyneto.kotlinrecyclerview.R
import br.com.andreyneto.kotlinrecyclerview.adapter.ProgrammingLanguageAdapter
import br.com.andreyneto.kotlinrecyclerview.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = ProgrammingLanguageAdapter(
            recyclerViewItems(), this) {
            recyclerView.snackbar("Clicked item: ${it.title}")
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun recyclerViewItems() : List<ProgrammingLanguage> {
        val kotlin = ProgrammingLanguage(R.drawable.kotlin,
            "Kotlin", 2010, "Kotlin description")
        return listOf(kotlin, kotlin)
    }
}
