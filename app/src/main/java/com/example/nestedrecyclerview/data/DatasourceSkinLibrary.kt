package com.example.nestedrecyclerview.data

import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.data.model.Skin

class DatasourceSkinLibrary {

    fun loadSkins():List<Skin>{
    return listOf(
        Skin("Dunkmaster", R.drawable.darius_dunkmasterskin),
        Skin("God King", R.drawable.darius_god_kingskin),
        Skin("High Noon", R.drawable.darius_highnoonskin),
        Skin("Woad King", R.drawable.darius_woadkingskin),
        Skin("Original", R.drawable.darius_originalskin),
        Skin("Crime City Night", R.drawable.darius_crimecitynightmareskin),
    )
    }
}