package com.example.nestedrecyclerview.adapter

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.data.DatasourceCharacters
import com.example.nestedrecyclerview.data.DatasourceSkins
import com.example.nestedrecyclerview.data.model.Character
import com.example.nestedrecyclerview.data.model.Skin
import com.example.nestedrecyclerview.databinding.ListCharacterBinding
import com.example.nestedrecyclerview.databinding.PopupAddSkinBinding
import java.lang.Exception

// We are passing @staticSkinLibrary from the MainActivity,
// so that we can use it in our pop up window to select a skin that should be add to our list.

class CharacterItemAdapter(
    private val context: Context,
    private var dataset: List<Character>,
    private var skinEntries: Map<String, MutableList<Skin>>,
    private var staticSkinLibrary : List<Skin>,
) : RecyclerView.Adapter<CharacterItemAdapter.CharacterItemViewHolder>() {

    private val selectedSkin : Skin = Skin("",0)

    inner class CharacterItemViewHolder(val binding: ListCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)


    fun loadNewData(newList: List<Character>) {
        dataset = newList
        //        Standard function that notifies the adapter that data has changes. It is required to run it everytime.
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding =
            ListCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        val character = dataset[position]
        val characterName = character.name

        holder.binding.characterName.text = characterName



//        SELECTING CORRECT SKIN LIST

        var adapter = SkinItemAdapter(context, emptyList())

//        val skinList = DatasourceSkins().skinMap().values.flatten()
        val skinList = skinEntries
        val skinCode = character.skinString

        val skinListForCurrentChampion = skinList[skinCode]
        Log.d(
            "Character Skin",
            "Set character : ${character.name} with skin string : ${character.skinString}"
        )

        try {
            adapter = SkinItemAdapter(context, skinListForCurrentChampion!!)
            val skinRecyclerView = holder.binding.skinRecyclerview
            skinRecyclerView.adapter = adapter
            skinRecyclerView.visibility = View.VISIBLE
        } catch (e: Exception) {
            Log.w("Character Skin", "Skin string not found.")
            val skinRecyclerView = holder.binding.skinRecyclerview
            skinRecyclerView.visibility = View.INVISIBLE
        }

//        ADDING NEW SKINS

        fun createCustomDialogBox (){

            var binding = PopupAddSkinBinding.inflate(LayoutInflater.from(context))

            val skinLibraryAdapter = StaticSkinLibraryAdapter(staticSkinLibrary,selectedSkin)

            val dialogBox = Dialog(context)
            dialogBox.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialogBox.setCancelable(false)
            dialogBox.setContentView(binding.root)

            val skinLibraryRecyclerView : RecyclerView = binding.skinLibraryRV
            skinLibraryRecyclerView.adapter = skinLibraryAdapter

            val closeDialogBoxButton : Button = binding.closePopupButton

            val addSelectionButton : Button = binding.addSelectionButton

            addSelectionButton.setOnClickListener{
//                val newEntry = Skin(newSkinName.text.toString(),holder.itemView.context.resources.getIdentifier(skinID.text.toString(),"drawable",holder.itemView.context.packageName))
                val newEntry = selectedSkin
                Log.d("Selected skin","Selected skin is ${selectedSkin.skinName}. Adding skin")
                skinEntries[characterName]!!.add(newEntry)
                adapter.loadNewData(skinEntries.values.flatten())
            }

            closeDialogBoxButton.setOnClickListener{
                dialogBox.dismiss()
            }
            dialogBox.show()

        }

        val addNewSkinButton = holder.binding.addSkinFAB

        addNewSkinButton.setOnClickListener{
            createCustomDialogBox()
        }

    }
}