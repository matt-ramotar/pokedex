package com.dropbox.pokedex.android.widget

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import app.cash.redwood.LayoutModifier
import com.dropbox.pokedex.android.theme.PIG
import com.dropbox.pokedex.treehouse.foundation.Color
import com.dropbox.pokedex.treehouse.schema.widget.Text
import com.dropbox.pokedex.treehouse.foundation.Color as PokedexColor
import com.dropbox.pokedex.treehouse.foundation.FontWeight as PokedexFontWeight
import com.dropbox.pokedex.treehouse.foundation.TextStyle as PokedexTextStyle
import com.dropbox.pokedex.treehouse.foundation.TextUnit as PokedexTextUnit


internal class PokedexText : Text<@Composable () -> Unit> {
    private var text by mutableStateOf("")
    private var color by mutableStateOf<PokedexColor?>(null)
    private var style by mutableStateOf<PokedexTextStyle?>(null)

    override var layoutModifiers: LayoutModifier = LayoutModifier
    override val value = @Composable {
        Text(
            text = text,
            color = color.compose(),
            style = style.compose()
        )
    }

    override fun text(text: String) {
        this.text = text
    }

    override fun color(color: PokedexColor?) {
        this.color = color
    }

    override fun style(style: PokedexTextStyle?) {
        this.style = style
    }


}

fun PokedexTextUnit?.compose(): TextUnit = when (this) {
    is PokedexTextUnit.Px -> TextUnit(this.value.toFloat(), type = TextUnitType.Unspecified)
    is PokedexTextUnit.Sp -> TextUnit(this.value, type = TextUnitType.Sp)
    null -> TextUnit.Unspecified
}

fun PokedexFontWeight?.compose(): FontWeight = when (this) {
    PokedexFontWeight.Black -> FontWeight.Black
    PokedexFontWeight.Bold -> FontWeight.Bold
    PokedexFontWeight.ExtraBold -> FontWeight.ExtraBold
    PokedexFontWeight.ExtraLight -> FontWeight.ExtraLight
    PokedexFontWeight.Light -> FontWeight.Light
    PokedexFontWeight.Medium -> FontWeight.Medium
    PokedexFontWeight.Normal -> FontWeight.Normal
    PokedexFontWeight.SemiBold -> FontWeight.SemiBold
    PokedexFontWeight.Thin -> FontWeight.Thin
    null -> FontWeight.Normal
}

fun PokedexTextStyle?.compose() = TextStyle(
    fontSize = this?.fontSize.compose(),
    fontWeight = this?.fontWeight.compose()
)

@Composable
fun PokedexColor?.compose() = when (this) {
    is Color.Name -> when (value) {
        "onBackground" -> PIG.Colors.standard.text
        else -> PIG.Colors.green.text
    }

    else -> PIG.Colors.red.text
}