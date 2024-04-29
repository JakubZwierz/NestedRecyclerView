package com.example.nestedrecyclerview.data

import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.data.model.Character

class DatasourceCharacters {

    fun loadCharacters(): List<Character> {
        return listOf(
            Character("Yuumi","Yuumi"),
            Character("Ahri","Ahri"),
            Character("Braum","Braum"),
            Character("Jinx","Jinx"),
            Character("Vi","Vi"),
            Character("Volibear","Volibear"),
            Character("Yasuo","Yasuo"),
        )
    }
}
