package com.example.conexaapp.ui.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.conexaapp.R
import com.example.conexaapp.databinding.NewItemBinding
import com.example.conexaapp.model.news.NewsModel
import com.squareup.picasso.Picasso

class AdapterNews (private var list: List<NewsModel>, private val interaction: (String) -> Unit) :
    RecyclerView.Adapter<AdapterNews.RecyclerAdapterHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterHolder {
        val layout = LayoutInflater.from(parent.context)
        return RecyclerAdapterHolder(layout.inflate(R.layout.new_item, parent, false))
    }

    override fun onBindViewHolder(
        holder: RecyclerAdapterHolder,
        position: Int
    ) {
        holder.paintIt(list[position], interaction)

    }

    override fun getItemCount(): Int = list.size

    fun updateList(filteredList: List<NewsModel>){
        this.list = filteredList
        notifyDataSetChanged()
    }

    class RecyclerAdapterHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var binding = NewItemBinding.bind(view)

        fun paintIt(new: NewsModel, interaction: (String) -> Unit) {
            with(binding){
                Picasso.get().load(new.image).into(ivNew)
                tvTitleNew.text=new.title
                tvSubtitleNew.text=new.description
            }

            binding.constraintNew.setOnClickListener {
                interaction(new.id)
            }
        }
    }
}