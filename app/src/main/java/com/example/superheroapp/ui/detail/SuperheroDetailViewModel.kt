package com.example.superheroapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.Repository
import com.example.superheroapp.domain.model.SuperheroDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroDetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _superheroDetail = MutableLiveData<SuperheroDetailModel>()
    val superheroDetail: LiveData<SuperheroDetailModel> get() = _superheroDetail

    fun loadSuperheroDetail(superheroId: String) {
        viewModelScope.launch {
            val result = repository.getSuperheroDetail(superheroId)
            _superheroDetail.value = result
        }
    }

}