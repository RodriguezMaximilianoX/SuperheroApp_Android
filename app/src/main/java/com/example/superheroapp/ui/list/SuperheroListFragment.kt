package com.example.superheroapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.superheroapp.databinding.FragmentSuperheroListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperheroListFragment : Fragment() {

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperheroListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}