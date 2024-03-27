package com.example.superheroapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.Repository
import com.example.superheroapp.domain.model.SuperheroModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _superheroes = MutableLiveData<List<SuperheroModel>>()
    val superheroes: LiveData<List<SuperheroModel>> get() = _superheroes
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(query: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = repository.searchSuperhero(query)
            _superheroes.value = result
            isLoading.postValue(false)
        }
    }
}