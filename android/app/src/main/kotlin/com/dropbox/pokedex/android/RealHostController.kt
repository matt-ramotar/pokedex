package com.dropbox.pokedex.android

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.ComponentBoxId
import com.dropbox.pokedex.treehouse.componentbox.ForestId
import com.dropbox.pokedex.treehouse.componentbox.TreeId
import com.dropbox.pokedex.treehouse.zipline.HostController

class RealHostController(override val start: ComponentBoxId) : HostController {

    private val mutableContent:
            MutableMap<ForestId, @Composable (slots: Map<TreeId, @Composable () -> Unit>) -> Unit> = mutableMapOf()
    override val content: Map<ForestId, (slots: Map<TreeId, @Composable () -> Unit>) -> Unit> = mutableContent

    fun add(
        forestId: ForestId,
        slots: @Composable (Map<TreeId, @Composable () -> Unit>) -> Unit
    ) {
        mutableContent[forestId] = slots
    }
}