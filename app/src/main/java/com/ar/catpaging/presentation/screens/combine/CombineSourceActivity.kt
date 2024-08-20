package com.ar.catpaging.presentation.screens.combine

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ar.catpaging.core.BaseActivity
import com.ar.catpaging.databinding.ActivityCatsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CombineSourceActivity : BaseActivity() {

    override val viewModel: CombineSourceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter(true)
        lifecycleScope.launch {
            viewModel.cats.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}