package com.github.tumusx.presenter.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.tumusx.domain.model.ImageResultVO

class ImageResultSearchedAdapter : RecyclerView.Adapter<ImageResultSearchedAdapter.ImageViewHolder>() {
    private val listImages: List<ImageResultVO> = emptyList()
     class ImageViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding){
        fun configUI(imageResultVO: ImageResultVO){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}