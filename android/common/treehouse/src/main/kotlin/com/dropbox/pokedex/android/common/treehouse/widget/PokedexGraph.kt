package com.dropbox.pokedex.android.common.treehouse.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import app.cash.redwood.LayoutModifier
import com.dropbox.pokedex.treehouse.componentbox.ComponentBox
import com.dropbox.pokedex.treehouse.componentbox.Forest
import com.dropbox.pokedex.treehouse.componentbox.LinkedForest
import com.dropbox.pokedex.treehouse.componentbox.Tree
import com.dropbox.pokedex.treehouse.schema.widget.Graph
import kotlinx.coroutines.flow.MutableStateFlow

internal class PokedexGraph : Graph<@Composable () -> Unit> {
    private lateinit var start: String
    private lateinit var graph: MutableMap<String, ComponentBox>
    private val componentBoxStateFlow = MutableStateFlow<ComponentBox?>(null)
    override fun start(start: String) {
        this.start = start
    }

    override fun graph(graph: Map<String, ComponentBox>) {
        this.graph = graph.toMutableMap()
    }

    override var layoutModifiers: LayoutModifier = LayoutModifier



    override val value = @Composable {
        val componentBox = componentBoxStateFlow.collectAsState()

        when (componentBox.value) {
            is Forest -> TODO()
            is LinkedForest -> TODO()
            is Tree -> TODO()
            null -> TODO()
        }
    }

}
