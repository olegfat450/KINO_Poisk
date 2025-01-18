package com.example.kino_temp

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kino_temp.databinding.ListItemBinding
import com.example.kino_temp.models.Omdb_2.T
import com.example.kino_temp.models.kinopoisk.Doc
import com.example.kino_temp.models.kinopoisk.ModelKinop
import com.squareup.picasso.Picasso

class ItemAdapter (): RecyclerView.Adapter<ItemAdapter.UVH>() {

    class UVH (val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){

    }

           private val callback = object: DiffUtil.ItemCallback<Doc>(){

               override fun areItemsTheSame(oldItem: Doc, newItem: Doc): Boolean {
                   return oldItem.id == newItem.id
               }

               @SuppressLint("DiffUtilEquals")
               override fun areContentsTheSame(oldItem: Doc, newItem: Doc): Boolean {
                  return oldItem == newItem
               }


           }

            val differ = AsyncListDiffer(this,callback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UVH {

        return UVH(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)) }

    override fun getItemCount() = differ.currentList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UVH, position: Int) {

            val article = differ.currentList[position]


        holder.binding.nameItem.text = "${article.name.toString()}"
        holder.binding.typeItem.text = "Жанр: ${article.type.toString()}"
        holder.binding.yearItem.text = "Год выпуска: ${article.year.toString()}"
        holder.binding.ratingItem.text= "Рейтинг IMDb: ${article.rating.imdb.toString()}"




        val image = Uri.parse(article.poster.previewUrl.toString())

        Picasso.get().load(image).into(holder.binding.imageItem)


    }
}