package com.github.tumusx.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.presenter.databinding.ContainerItemSearchImageBinding

class ImageResultSearchedAdapter :
    RecyclerView.Adapter<ImageResultSearchedAdapter.ImageViewHolder>() {
    private var listImages: List<String> = emptyList()

    class ImageViewHolder(private val binding: ContainerItemSearchImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun configUI(imageUrl: String) {
            Glide.with(binding.icSearchImage).load(imageUrl).into(binding.icSearchImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ContainerItemSearchImageBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.configUI(listImages[position])
    }

    override fun getItemCount() = listImages.size

    fun updateList(urlImageList: List<String>){
        listImages = urlImageList
        notifyDataSetChanged()
    }
}