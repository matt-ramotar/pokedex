package com.dropbox.pokedex.android


import androidx.compose.runtime.Composable
import app.cash.redwood.treehouse.AppService
import app.cash.redwood.treehouse.TreehouseApp
import com.dropbox.pokedex.android.widget.PokedexText
import com.dropbox.pokedex.android.widget.PokedexTextInput
import com.dropbox.pokedex.treehouse.schema.widget.*

class AndroidPokedexWidgetFactory<A : AppService>(
    private val treehouseApp: TreehouseApp<A>,
) : PokedexWidgetFactory<@Composable () -> Unit> {
    override fun TextInput(): TextInput<() -> Unit> = PokedexTextInput()
    override fun Text(): Text<() -> Unit> = PokedexText()

    override fun Image(): Image<() -> Unit> {
        TODO("Not yet implemented")
    }

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