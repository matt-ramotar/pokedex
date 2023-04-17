package com.dropbox.pokedex.treehouse.presenter.componentbox.component

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.Color
import com.dropbox.pokedex.treehouse.componentbox.Component
import com.dropbox.pokedex.treehouse.componentbox.Text
import com.dropbox.pokedex.treehouse.componentbox.TextStyle

@Composable
fun text(
    text: String,
    color: Color? = null,
    style: TextStyle? = null
): Component = Text(text, color, style)
