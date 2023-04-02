package com.dropbox.pokedex.android.common.treehouse

import androidx.compose.runtime.Composable
import app.cash.redwood.treehouse.AppService
import app.cash.redwood.treehouse.TreehouseApp
import com.dropbox.pokedex.android.common.treehouse.widget.PokedexImage
import com.dropbox.pokedex.android.common.treehouse.widget.PokedexText
import com.dropbox.pokedex.android.common.treehouse.widget.PokedexTextInput
import com.dropbox.pokedex.treehouse.schema.widget.*


class AndroidPokedexWidgetFactory<A : AppService>(
    private val treehouseApp: TreehouseApp<A>,
) : PokedexWidgetFactory<@Composable () -> Unit> {
    override fun TextInput(): TextInput<() -> Unit> = PokedexTextInput()
    override fun Text(): Text<() -> Unit> = PokedexText()

    override fun Image(): Image<() -> Unit> = PokedexImage()

    override fun Icon(): Icon<() -> Unit> {
        TODO("Not yet implemented")
    }

    override fun ContainedButton(): ContainedButton<() -> Unit> {
        TODO("Not yet implemented")
    }

    override fun AnnotatedString(): AnnotatedString<() -> Unit> {
        TODO("Not yet implemented")
    }

}