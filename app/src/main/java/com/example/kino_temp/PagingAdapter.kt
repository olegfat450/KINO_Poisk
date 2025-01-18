package com.example.kino_temp

import android.annotation.SuppressLint
import android.content.ClipData
import android.media.RouteListingPreference.Item
import android.net.Uri
import android.view.LayoutInflater
import android.view.View


import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kino_temp.ItemAdapter.UVH
import com.example.kino_temp.databinding.ListItemBinding
import com.example.kino_temp.models.kinopoisk.Doc
import com.example.kino_temp.retrofit.r.api.ApiService
import com.squareup.picasso.Picasso


class PagingAdapter: PagingDataAdapter<Doc,PagingAdapter.MVH>(DIFF_CALLBACK) {

         inner class MVH (val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

       companion object{
           val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Doc> () {
               override fun areItemsTheSame(oldItem: Doc, newItem: Doc): Boolean {
                  return oldItem.id == newItem.id
               }

               override fun areContentsTheSame(oldItem: Doc, newItem: Doc): Boolean {
                   return oldItem == newItem }
           }
       }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MVH, position: Int) {


        val item = getItem(position)
         val name = item?.name
        if (name != null) holder.binding.nameItem.text = "${name.toString()}" else  holder.binding.nameItem.text = "${item?.alternativeName.toString()}"
        holder.binding.typeItem.text = "Жанр: ${item?.type.toString()}"
        holder.binding.yearItem.text = "Год выпуска: ${item?.year.toString()}"

        holder.binding.ratingItem.text= "Рейтинг IMDb: ${item?.rating?.imdb.toString()}"
       // val image = Uri.parse(item?.poster?.previewUrl.toString())

        if (item?.poster?.previewUrl != null) { Picasso.get().load(Uri.parse(item.poster.previewUrl.toString())).into(holder.binding.imageItem)} else
            holder.binding.imageItem.setImageResource(R.drawable.no_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MVH {
        return MVH(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}