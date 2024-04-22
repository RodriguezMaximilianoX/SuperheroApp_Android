package com.example.superheroapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroapp.R
import com.example.superheroapp.databinding.ActivitySuperheroDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SuperheroDetailActivity @Inject constructor(private val viewModel: SuperheroDetailViewModel) : AppCompatActivity() {
    private lateinit var binding : ActivitySuperheroDetailBinding
    companion object {
        const val EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val superheroId = intent.getStringExtra(EXTRA_ID)
    }
}