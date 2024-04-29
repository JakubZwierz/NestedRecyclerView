package com.example.nestedrecyclerview

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.SearchView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nestedrecyclerview.adapter.CharacterItemAdapter
import com.example.nestedrecyclerview.data.DatasourceCharacters
import com.example.nestedrecyclerview.data.DatasourceSkinLibrary
import com.example.nestedrecyclerview.data.DatasourceSkins
import com.example.nestedrecyclerview.data.model.Character
import com.example.nestedrecyclerview.data.model.Skin
import com.example.nestedrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//  Variable for searchview
    lateinit var searchView: SearchView

    // The reason we are saving the skin entries here is, that when we are creating a new character we need to create an entry in the skin list as well.
    // Since our skin list is saved as a map, we are using the name of the character as a key for the skin list, which is saved as a value.
    var skinEntries : MutableMap<String, MutableList<Skin>> = DatasourceSkins().skinMap().toMutableMap()

//    List of characters that will be updated
    var characterEntries : MutableList<Character> = DatasourceCharacters().loadCharacters().toMutableList()

    val staticSkinLibrary : List<Skin> = DatasourceSkinLibrary().loadSkins()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val characterList = DatasourceCharacters().loadCharacters()
        val adapter = CharacterItemAdapter(this, characterList, skinEntries, staticSkinLibrary)

        val characterRecyclerView = binding.characterRecyclerview
        characterRecyclerView.adapter = adapter

//        SEARCH

        searchView = binding.searchBar

        searchView.setOnQueryTextListener( object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrBlank()){
                    adapter.loadNewData(characterEntries)
                } else {
                    val filteredList = characterEntries.filter { character ->
                        character.name.contains(newText,ignoreCase = true)
                    }
                    adapter.loadNewData(filteredList)
                }
                return false
            }
        })

//        ADDING NEW CHARACTERS
        
        val addNewCharacterButton = binding.addCharacterFAB

        addNewCharacterButton.setOnClickListener{
            val newCharacterName = EditText(this)

            AlertDialog.Builder(this)
                .setTitle("Add new item")
                .setView(newCharacterName)
                .setNegativeButton("Cancel") { _, _ ->

                }
                .setPositiveButton("Add") { _, _ ->
                    val newEntry = Character(newCharacterName.text.toString(),newCharacterName.text.toString())
                    characterEntries.add(newEntry)
                    skinEntries[newEntry.name]= emptyList<Skin>().toMutableList()
                    adapter.loadNewData(characterEntries)
                }
                .show()
        }
    }
}