package com.example.superheroapp.ui.list.adapter

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.superheroapp.databinding.SuperheroItemBinding
import com.example.superheroapp.domain.model.SuperheroModel
import com.example.superheroapp.ui.detail.SuperheroDetailActivity

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = SuperheroItemBinding.bind(view)

    fun render(superheroModel: SuperheroModel, onClickListener: (String) -> Unit) {

        val context = binding.tvSuperhero.context

        Glide.with(context)
            .load(superheroModel.image)
            .into(binding.ivSuperhero)

        binding.tvSuperhero.text = superheroModel.name

        binding.root.setOnClickListener {
            val context = itemView.context
            val intent = Intent(context, SuperheroDetailActivity::class.java).apply {
                putExtra("SUPERHERO_ID", superheroModel.id)
            }
            context.startActivity(intent)
        }
    }

}