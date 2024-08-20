package com.ar.catpaging.presentation.screens.remote

import com.ar.catpaging.core.BaseViewModel
import com.ar.catpaging.domain.repository.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RemoteSourceViewModel @Inject constructor(private val repository: CatRepository) :
    BaseViewModel() {
    override val dataSource = repository.getCatsFromNetwork()
}