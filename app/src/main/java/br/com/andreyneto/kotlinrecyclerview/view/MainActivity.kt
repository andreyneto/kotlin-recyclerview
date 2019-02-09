package br.com.andreyneto.kotlinrecyclerview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.andreyneto.kotlinrecyclerview.R
import br.com.andreyneto.kotlinrecyclerview.adapter.ProgrammingLanguageAdapter
import br.com.andreyneto.kotlinrecyclerview.adapter.RepositoryAdapter
import br.com.andreyneto.kotlinrecyclerview.api.RepositoryRetriever
import br.com.andreyneto.kotlinrecyclerview.model.GitHubRepositoriesResult
import br.com.andreyneto.kotlinrecyclerview.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.design.snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val repositoryRetriever = RepositoryRetriever()

    private val callback = object : Callback<GitHubRepositoriesResult> {
        override fun onFailure(call: Call<GitHubRepositoriesResult>, t: Throwable) {
            recyclerView.snackbar("Load failure")
        }

        override fun onResponse(call: Call<GitHubRepositoriesResult>, response: Response<GitHubRepositoriesResult>) {
            recyclerView.snackbar("Load finished")
            response.body()?.repositories?.let {repositories ->
                recyclerView.adapter = RepositoryAdapter(repositories,this@MainActivity) {
                    recyclerView.snackbar("Clicked item: ${it.name}")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadDefaultRecylerView()
    }

    private fun loadDefaultRecylerView() {
        recyclerView.adapter = ProgrammingLanguageAdapter(
            recyclerViewItems(), this) {
            recyclerView.snackbar("Loading ${it.title} repositories")
            repositoryRetriever.getLanguageRepositories(callback, it.title)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun recyclerViewItems() : List<ProgrammingLanguage> {
        val kotlin = ProgrammingLanguage(R.drawable.kotlin,
            "Kotlin", 2010, "Kotlin description")
        val java = ProgrammingLanguage(R.drawable.kotlin,
            "Java", 2010, "Kotlin description")
        return listOf(kotlin, java)
    }
}
