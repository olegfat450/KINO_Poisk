package com.example.kino_temp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kino_temp.databinding.LoadStateBinding


class MainLoadStateAdapter(): LoadStateAdapter<MainLoadStateAdapter.LSVH>() {

    class LSVH(val binding: LoadStateBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: LSVH, loadState: LoadState) {
       holder.binding.apply { progressBar.visibility = View.VISIBLE }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LSVH {
        return LSVH(LoadStateBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}