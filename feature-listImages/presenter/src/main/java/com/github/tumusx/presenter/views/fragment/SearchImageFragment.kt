package com.github.tumusx.presenter.views.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.lifecycleScope
import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.presenter.adapter.ImageResultSearchedAdapter
import com.github.tumusx.presenter.databinding.FragmentSearchImageBinding
import com.github.tumusx.presenter.viewModel.ListImageViewModel
import com.github.tumusx.shared.State
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchImageFragment : Fragment() {
    private lateinit var binding: FragmentSearchImageBinding
    private val viewModelList: ListImageViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchImageBinding.inflate(layoutInflater)
        onConfigSearchImage()
        observableItems()
        return binding.root
    }

    private fun configAdapter(listImageUrl: List<String>) {
        val imageResultAdapter = ImageResultSearchedAdapter()
        binding.rvImageResultSearch.adapter = imageResultAdapter
        imageResultAdapter.updateList(listImageUrl)
    }

    private fun observableItems() {
        viewModelList.stateReceiverImage.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.SuccessProcess<*> -> {
                    val result = (state.dataResult as ImageResultVO).imagesListResult
                    configAdapter(result)
                    Log.d(
                        "TESTANDO",
                        result.toString()
                    )
                }

                is State.ErrorProcess -> {
                    Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()
                    binding.rvImageResultSearch.visibility = View.GONE
                }

                is State.LoadingProcess -> {
                    print("LOADING")
                }

                else -> println("Unknown error")
            }
        }
    }

    private fun onConfigSearchImage() {
        binding.searchImages.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { searchItem -> onSetupSearchItem(searchItem) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                binding.rvImageResultSearch.visibility = View.VISIBLE
                newText?.let { query -> onSetupSearchItem(query) }
                return false
            }

        })
    }

    private fun onSetupSearchItem(query: String) {
        lifecycleScope.launch {
            viewModelList.searchImage(query)
        }
    }
}