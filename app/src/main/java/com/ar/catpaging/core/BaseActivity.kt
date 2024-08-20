package com.ar.catpaging.core

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.ar.catpaging.databinding.ActivityCatsBinding
import com.ar.catpaging.presentation.adapter.CatsAdapter
import com.ar.catpaging.presentation.adapter.CatsLoadStateAdapter

abstract class BaseActivity: AppCompatActivity() {
    abstract val viewModel: BaseViewModel
    lateinit var binding: ActivityCatsBinding
    val adapter by lazy { CatsAdapter() }

    fun initAdapter(isMediator: Boolean = false) {
        binding.recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = CatsLoadStateAdapter { adapter.retry() },
            footer = CatsLoadStateAdapter { adapter.retry() }
        )
        adapter.addLoadStateListener { loadState ->
            val refreshState =
                if (isMediator) {
                    loadState.mediator?.refresh
                } else {
                    loadState.source.refresh
                }
            binding.recyclerView.isVisible = refreshState is LoadState.NotLoading
            binding.progressBar.isVisible = refreshState is LoadState.Loading
            binding.buttonRetry.isVisible = refreshState is LoadState.Error
            handleError(loadState)
        }
        binding.buttonRetry.setOnClickListener {
            adapter.retry()
        }
    }

    private fun handleError(loadState: CombinedLoadStates) {
        val errorState = loadState.source.append as? LoadState.Error
            ?: loadState.source.prepend as? LoadState.Error

        errorState?.let {
            Toast.makeText(this, "${it.error}", Toast.LENGTH_LONG).show()
        }
    }
}