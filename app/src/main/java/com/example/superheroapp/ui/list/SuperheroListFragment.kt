package com.example.superheroapp.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.databinding.FragmentSuperheroListBinding
import com.example.superheroapp.ui.detail.SuperheroDetailActivity
import com.example.superheroapp.ui.list.adapter.SuperheroAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperheroListFragment : Fragment() {

    private val viewModel by viewModels<SuperheroListViewModel>()

    private lateinit var adapter: SuperheroAdapter

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSearchView()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = SuperheroAdapter(onClickListener = { superheroId ->
            navigateToDetail(superheroId)
        })
        binding.rvSuperhero.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSuperhero.adapter = adapter
        viewModel.superheroes.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = false
            adapter.updateList(it)
        })
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query.let {
                    binding.progressBar.isVisible = true
                    viewModel.onCreate(it.orEmpty())
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperheroListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(requireContext(), SuperheroDetailActivity::class.java)
        intent.putExtra(SuperheroDetailActivity.EXTRA_ID, id)
        startActivity(intent)
    }

}