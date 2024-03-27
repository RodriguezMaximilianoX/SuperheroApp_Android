package com.example.superheroapp.ui.list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.superheroapp.databinding.SuperheroItemBinding
import com.example.superheroapp.domain.model.SuperheroModel

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = SuperheroItemBinding.bind(view)

    fun render(superheroModel: SuperheroModel) {

        val context = binding.tvSuperhero.context

        Glide.with(context)
            .load(superheroModel.image)
            .into(binding.ivSuperhero)

        binding.tvSuperhero.text = superheroModel.name
    }

}