package com.example.nestedrecyclerview.data

import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.data.model.Skin

class DatasourceSkins {

    fun skinMap(): Map<String, MutableList<Skin>> {
        return mapOf(
            "Yuumi" to mutableListOf(
                Skin("Original", R.drawable.yuumi_originalskin),
                Skin("Battle Principal", R.drawable.yuumi_battleprincipalskin),
                Skin("Yuubee", R.drawable.yuumi_yuubeeskin),
                Skin("Shiba Yuumi", R.drawable.yuumi_heartseekerskin),
                Skin("Heartseeker", R.drawable.yuumi_shibaskin),
            ),
            "Ahri" to mutableListOf(
                Skin("Original", R.drawable.ahri_originalskin),
                Skin("Midnight", R.drawable.ahri_midnightskin),
                Skin("Foxfire", R.drawable.ahri_foxfireskin),
                Skin("Dynasty", R.drawable.ahri_dynastyskin),
                Skin("Pop Star", R.drawable.ahri_academyskin),
                Skin("Academy", R.drawable.ahri_popstarskin),
            ),
            "Braum" to mutableListOf(
                Skin("Original", R.drawable.braum_originalskin),
                Skin("Dragon Slayer", R.drawable.braum_dragonslayerskin),
                Skin("Mafia", R.drawable.braum_mafiaskin),
                Skin("El Tigres", R.drawable.braum_eltigreskin),
                Skin("Milionhearth", R.drawable.braum_braumlionheartskin),
                Skin("Pool Party", R.drawable.braum_poolpartyskin),
            ),
            "Jinx" to mutableListOf(
                Skin("Original", R.drawable.jinx_originalskin),
                Skin("Arcane", R.drawable.jinx_arcaneskin),
                Skin("Battle Cat", R.drawable.jinx_battlecatskin),
                Skin("Cafe Cuties", R.drawable.jinx_cafecutiesskin),
                Skin("Fire Cracker", R.drawable.jinx_firecrackerskin),
                Skin("Star Guardian", R.drawable.jinx_starguardianskin),
            ),
            "Vi" to mutableListOf(
                Skin("Original", R.drawable.vi_originalskin),
                Skin("Arcane", R.drawable.vi_arcaneskin),
                Skin("Hearthache", R.drawable.vi_heartacheskin),
                Skin("Neon Strike", R.drawable.vi_neonstrikeskin),
                Skin("Officer", R.drawable.vi_officerskin),
                Skin("Project", R.drawable.vi_primalambushskin),
                Skin("Primal Ambush", R.drawable.vi_projectskin),
            ),
            "Volibear" to mutableListOf(
                Skin("Original", R.drawable.volibear_originalskin),
                Skin("Captain", R.drawable.volibear_captainskin),
                Skin("Rune Guard", R.drawable.volibear_runeguardskin),
                Skin("Duality Dragon", R.drawable.volibear_dualitydragonskin),
                Skin("The Thousand Pierced Bear", R.drawable.volibear_thethousand_piercedbearskin),
            ),
            "Yasuo" to mutableListOf(
                Skin("Yasuo", R.drawable.yasuo_originalskin),
                Skin("Foreseen", R.drawable.yasuo_foreseenskin),
                Skin("Odyssey", R.drawable.yasuo_odysseyskin),
                Skin("Night Bringer", R.drawable.yasuo_nightbringerskin),
                Skin("Battle Boss", R.drawable.yasuo_battlebossskin),
                Skin("Spirit Blossom", R.drawable.yasuo_spiritblossomskin),
                Skin("Truth Dragon", R.drawable.yasuo_truthdragonskin),
            ),
            )
    }
}
