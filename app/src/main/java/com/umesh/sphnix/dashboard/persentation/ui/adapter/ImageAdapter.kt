package com.umesh.sphnix.dashboard.persentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.umesh.sphnix.R
import com.umesh.sphnix.databinding.ListItemBinding


class ImageAdapter(var list: List<String>, val onClickPost: OnClickPost) :
    RecyclerView.Adapter<ImageAdapter.ImageListViewHolder>() {
    lateinit var binding: ListItemBinding


    inner class ImageListViewHolder() : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: String/*PickSumApiResponseItem*/) {
         /*   binding.tvPhotoAlbumName.text = article.title
            binding.tvPhotoAlbumDiscription.text = article.description

            setImageByGlide(binding.root.context,article.imageHref?:"",binding.ivPhotoAlbum)
            binding.root.setOnClickListener {
                onClickPost.openImageListPost(article,layoutPosition)
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        )
        return ImageListViewHolder()
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface OnClickPost {
        fun openImageListPost(article: String, position: Int)
    }
    }