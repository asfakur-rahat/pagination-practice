package com.ar.catpaging.presentation.screens.combine

import androidx.lifecycle.viewModelScope
import com.ar.catpaging.core.BaseViewModel
import com.ar.catpaging.domain.repository.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CombineSourceViewModel@Inject constructor(private val repository: CatRepository) :
    BaseViewModel() {

    init {
        viewModelScope.launch {
            repository.deleteDummyData()
        }
    }

    override val dataSource = repository.getCatsFromMediator()
}