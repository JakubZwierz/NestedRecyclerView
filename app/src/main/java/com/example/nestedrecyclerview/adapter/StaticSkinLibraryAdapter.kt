package com.example.nestedrecyclerview.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.data.model.Skin
import com.example.nestedrecyclerview.databinding.ListSkinBinding
import com.example.nestedrecyclerview.databinding.ListSkinLibraryBinding

class StaticSkinLibraryAdapter(
    private var dataset: List<Skin>,
    var selectedSkin : Skin,
) : RecyclerView.Adapter<StaticSkinLibraryAdapter.StaticSkinLibraryViewHolder>() {

    inner class StaticSkinLibraryViewHolder(val binding: ListSkinLibraryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaticSkinLibraryViewHolder {
        val binding =
            ListSkinLibraryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StaticSkinLibraryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: StaticSkinLibraryViewHolder, position: Int) {
        val skin = dataset[position]
        val skinName = skin.skinName
        val skinSplashArt = skin.backgroundImage

        val selectSkinButton = holder.binding.selectSkinButton

        holder.binding.librarySkinImageId.setImageResource(skinSplashArt)
        holder.binding.librarySkinName.text = skinName

        selectSkinButton.setOnClickListener{
            selectedSkin = Skin(skinName,skinSplashArt)
            Log.d("Selected skin", "The selected skin values are : skinName: ${selectedSkin.skinName} and ${selectedSkin.backgroundImage}")
        }
    }
}