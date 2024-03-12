package com.example.superheroapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperheroDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)
    }
}