package com.ar.catpaging.presentation.screens.local

import androidx.lifecycle.viewModelScope
import com.ar.catpaging.core.BaseViewModel
import com.ar.catpaging.domain.model.Cat
import com.ar.catpaging.domain.repository.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalSourceViewModel @Inject constructor(private val repository: CatRepository) :
    BaseViewModel() {

    override val dataSource = repository.getCatsFromDb()

    fun fillWithDummyCats() {
        val dummyCats = mutableListOf<Cat>()
        for (i in 0..10000) {
            dummyCats.add(Cat(i.toString(), "https://cdn2.thecatapi.com/images/ja.jpg"))
        }
        viewModelScope.launch {
            repository.fillWithDummyCats(dummyCats)
        }
    }
}