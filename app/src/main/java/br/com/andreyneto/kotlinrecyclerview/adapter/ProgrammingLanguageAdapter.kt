package br.com.andreyneto.kotlinrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.andreyneto.kotlinrecyclerview.R
import br.com.andreyneto.kotlinrecyclerview.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.programming_language_item.view.*

class ProgrammingLanguageAdapter(
    private val items: List<ProgrammingLanguage>,
    private val context: Context,
    private val listener: (ProgrammingLanguage) -> Unit
) : Adapter<ProgrammingLanguageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
         ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.programming_language_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position], listener)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(item: ProgrammingLanguage,
                     listener: (ProgrammingLanguage) -> Unit) = with(itemView){
            ivMain.setImageDrawable(ContextCompat.getDrawable(context, item.imageResourceId))
            tvTitle.text = item.title
            tvLaunchYear.text = item.year.toString()
            tvDescription.text = item.description
            setOnClickListener { listener(item) }
        }
    }
}