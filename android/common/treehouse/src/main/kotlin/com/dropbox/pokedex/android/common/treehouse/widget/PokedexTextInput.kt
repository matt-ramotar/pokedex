package com.dropbox.pokedex.android.common.treehouse.widget

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import app.cash.redwood.LayoutModifier
import com.dropbox.pokedex.treehouse.schema.widget.TextInput
import com.dropbox.pokedex.treehouse.state.TextFieldState

internal class PokedexTextInput : TextInput<@Composable () -> Unit> {
    override fun state(state: TextFieldState) {
        TODO("Not yet implemented")
    }

    override fun hint(hint: String) {
        TODO("Not yet implemented")
    }

    override fun onChange(onChange: ((TextFieldState) -> Unit)?) {
        TODO("Not yet implemented")
    }

    override var layoutModifiers: LayoutModifier
        get() = TODO("Not yet implemented")
        set(value) {}

    override val value = @Composable {
        Text(
            text = "",
            color = MaterialTheme.colors.onBackground
        )
    }


}