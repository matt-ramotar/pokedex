package com.dropbox.pokedex.android.common.treehouse.widget

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
import com.dropbox.pokedex.android.common.pig.PIG
import com.dropbox.pokedex.treehouse.componentbox.Color
import com.dropbox.pokedex.treehouse.schema.widget.Text
import com.dropbox.pokedex.treehouse.componentbox.Color as PokedexColor
import com.dropbox.pokedex.treehouse.componentbox.FontWeight as PokedexFontWeight
import com.dropbox.pokedex.treehouse.componentbox.TextStyle as PokedexTextStyle
import com.dropbox.pokedex.treehouse.componentbox.TextUnit as PokedexTextUnit


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

@Composable
fun PokedexTextStyle?.compose() = when (this) {
    is PokedexTextStyle.Name -> when (this.value) {
        "h1" -> PIG.Typography.h1
        "h2" -> PIG.Typography.h2
        "h3" -> PIG.Typography.h3
        "h4" -> PIG.Typography.h4
        "h5" -> PIG.Typography.h5
        "h6" -> PIG.Typography.h6
        "body1" -> PIG.Typography.body1
        "body2" -> PIG.Typography.body2
        "caption" -> PIG.Typography.caption
        else -> PIG.Typography.body1
    }

    is PokedexTextStyle.Style -> TextStyle(
        fontSize = fontSize.compose(),
        fontWeight = fontWeight.compose()
    )

    null -> PIG.Typography.body1
}

@Composable
fun PokedexColor?.compose() = when (this) {
    is Color.Name -> when (value) {
        "onBackground" -> PIG.Colors.standard.text
        else -> PIG.Colors.green.text
    }

    else -> PIG.Colors.red.text
}