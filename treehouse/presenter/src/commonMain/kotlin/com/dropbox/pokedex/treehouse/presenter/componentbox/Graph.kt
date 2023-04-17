package com.dropbox.pokedex.treehouse.presenter.componentbox

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.ComponentBox
import com.dropbox.pokedex.treehouse.componentbox.ComponentBoxId
import com.dropbox.pokedex.treehouse.componentbox.Graph

@Composable
fun graph(start: ComponentBoxId, componentBoxes: @Composable Graph.() -> Unit): Graph = Graph(start).apply {
    componentBoxes()
}

@Composable
fun Graph.componentBox(componentBoxId: ComponentBoxId, componentBox: ComponentBox) {
    componentBoxes[componentBoxId] = componentBox
}

