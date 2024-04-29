package com.example.nestedrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.data.model.Character
import com.example.nestedrecyclerview.databinding.ListSkinBinding
import com.example.nestedrecyclerview.data.model.Skin

class SkinItemAdapter(
    private val context: Context,
    private var dataset: List<Skin>
) : RecyclerView.Adapter<SkinItemAdapter.SkinItemViewHolder>() {

    inner class SkinItemViewHolder(val binding: ListSkinBinding) : RecyclerView.ViewHolder(binding.root)

    fun loadNewData ( newList : List<Skin> ){
        dataset = newList
        //        Standard function that notifies the adapter that data has changes. It is required to run it everytime.
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkinItemViewHolder {
        val binding = ListSkinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SkinItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: SkinItemViewHolder, position: Int) {
        val skin = dataset[position]
        val skinName = skin.skinName
        val skinSplashArt = skin.backgroundImage

        holder.binding.skinTitle.text = skinName
//        holder.binding.skinTitle.setText(skin.skinName)
        holder.binding.skinSplashArt.setImageResource(skinSplashArt)
    }

}