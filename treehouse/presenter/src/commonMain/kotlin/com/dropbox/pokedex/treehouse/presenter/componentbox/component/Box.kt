package com.dropbox.pokedex.treehouse.presenter.componentbox.component

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.Box
import com.dropbox.pokedex.treehouse.componentbox.Component
import com.dropbox.pokedex.treehouse.componentbox.Events
import com.dropbox.pokedex.treehouse.componentbox.Modifier

@Composable
fun box(
    modifier: Modifier = Modifier(),
    events: Events? = null,
    children: @Composable Box.() -> Unit
): Component = Box(modifier, events = events).apply {
    children()
}