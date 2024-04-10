package com.example.superheroapp.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.domain.model.SuperheroModel

class SuperheroAdapter(
    private var superheroList: List<SuperheroModel> = emptyList(),
    private val onClickListener: (String) -> Unit
) : RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(list: List<SuperheroModel>) {
        superheroList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.superhero_item, parent, false)
        )
    }

    override fun getItemCount() = superheroList.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.render(superheroList[position], onClickListener)
    }
}