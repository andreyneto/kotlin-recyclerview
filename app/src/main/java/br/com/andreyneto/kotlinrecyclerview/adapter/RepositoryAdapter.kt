package br.com.andreyneto.kotlinrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.andreyneto.kotlinrecyclerview.R
import br.com.andreyneto.kotlinrecyclerview.model.Repository
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.repository_item.view.*

class RepositoryAdapter(
    private val items: List<Repository>,
    private val context: Context,
    private val listener: (Repository) -> Unit
) : Adapter<RepositoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
         ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.repository_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position], listener)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Repository,
                     listener: (Repository) -> Unit) = with(itemView){
            Glide.with(ivMain.context).load(item.owner?.avatar_url).into(ivMain)
            tvTitle.text = item.name
            tvOwner.text = item.owner?.login
            tvDescription.text = item.description
            setOnClickListener { listener(item) }
        }
    }
}