package com.dropbox.pokedex.android.widget

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import app.cash.redwood.LayoutModifier
import com.dropbox.pokedex.treehouse.foundation.Color
import com.dropbox.pokedex.treehouse.foundation.TextStyle
import com.dropbox.pokedex.treehouse.schema.widget.Text

internal class PokedexText : Text<@Composable () -> Unit> {
    private var text by mutableStateOf("")
    private var color by mutableStateOf<Color?>(null)
    private var style by mutableStateOf<TextStyle?>(null)

    override var layoutModifiers: LayoutModifier = LayoutModifier
    override val value = @Composable {
        Text(
            text = text,
            color = MaterialTheme.colors.onBackground
        )
    }

    override fun text(text: String) {
        this.text = text
    }

    override fun color(color: Color?) {
        this.color = color
    }

    override fun style(style: TextStyle?) {
        this.style = style
    }


}