package com.nanyo.belajarlagi14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_show.view.*

class ViewAdapterUnsplash(
    val list: List<ViewUnsplash>)
    : RecyclerView.Adapter<ViewAdapterUnsplash.ViewHolderUnsplash>() {

    inner class ViewHolderUnsplash(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUnsplash {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_show, parent, false)
        return ViewHolderUnsplash(view)
    }

    override fun onBindViewHolder(holder: ViewHolderUnsplash, position: Int) {
        val unsplashData = list[position]
        holder.itemView.tvDownloads.text = unsplashData.downloadsUnplash
        holder.itemView.tvFeatured.text = unsplashData.featuredUnsplash
        holder.itemView.tvViews.text = unsplashData.viewsUnsplash
        Glide.with(holder.itemView.context)
            .load(unsplashData.imgUnsplash)
            .into(holder.itemView.ivImage)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}