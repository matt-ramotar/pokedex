package com.dropbox.pokedex.android.common.pig

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.dropbox.pokedex.android.common.pig.color.Colors
import com.dropbox.pokedex.android.common.pig.color.LocalColorScheme
import com.dropbox.pokedex.android.common.pig.color.LocalColors
import com.dropbox.pokedex.android.common.pig.color.asColors
import androidx.compose.material3.MaterialTheme as Material3Theme
import androidx.compose.material3.Shapes as Shapes3


private val PokedexShapes = Shapes(
    small = RoundedCornerShape(0.dp),
    medium = RoundedCornerShape(0.dp),
    large = RoundedCornerShape(0.dp),
)

private val Pokedex3Shapes = Shapes3(
    extraSmall = RoundedCornerShape(0.dp),
    small = RoundedCornerShape(0.dp),
    medium = RoundedCornerShape(0.dp),
    large = RoundedCornerShape(0.dp),
    extraLarge = RoundedCornerShape(0.dp),
)

@Composable
fun PokedexTheme(
    colorScheme: ColorScheme = PIG.ColorScheme,
    shapes: Shapes3 = Pokedex3Shapes,
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
    ) {
        Material3Theme(colorScheme = colorScheme, shapes = shapes, content = content)
    }
}


@Composable
fun PokedexTheme(
    colors: Colors,
    shapes: Shapes = PokedexShapes,
    typography: Typography = PokedexTypography,
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography
    ) {
        MaterialTheme(
            colors = colors.asColors(),
            shapes = shapes,
            content = content,
            typography = typography
        )
    }
}