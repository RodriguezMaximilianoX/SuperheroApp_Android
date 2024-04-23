package com.example.superheroapp.ui.detail

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.superheroapp.databinding.ActivitySuperheroDetailBinding
import com.example.superheroapp.domain.model.SuperheroDetailModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class SuperheroDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuperheroDetailBinding
    private val viewModel by viewModels<SuperheroDetailViewModel>()

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val superheroId = intent.getStringExtra(EXTRA_ID)
        superheroId?.let {
            viewModel.loadSuperheroDetail(it)
        }

        viewModel.superheroDetail.observe(this, Observer { superheroData ->
            createUI(superheroData)
        })
    }

    private fun createUI(superheroData: SuperheroDetailModel) {

        Glide.with(this)
            .load(superheroData.image)
            .into(binding.ivSuperheroDetail)

        binding.tvSuperheroName.text = superheroData.name

        stats(superheroData)
    }

    private fun stats(superheroData: SuperheroDetailModel) {
        updateHeights(binding.viewCombat, superheroData.combat)
        updateHeights(binding.viewDurability, superheroData.durability)
        updateHeights(binding.viewIntelligence, superheroData.intelligence)
        updateHeights(binding.viewPower, superheroData.power)
        updateHeights(binding.viewSpeed, superheroData.speed)
        updateHeights(binding.viewStrength, superheroData.strength)
    }

    private fun updateHeights(view: View, stat: String) {
        val params = view.layoutParams
        params.height = pixelToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pixelToDp(px: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_PX,
            px+50,
            resources.displayMetrics
        ).roundToInt()
    }
}