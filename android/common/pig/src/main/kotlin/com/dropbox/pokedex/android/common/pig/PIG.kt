package com.dropbox.pokedex.android.common.pig


import androidx.compose.material.Typography
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.dropbox.pokedex.android.common.pig.color.Colors
import com.dropbox.pokedex.android.common.pig.color.LocalColors
import com.dropbox.pokedex.android.common.pig.color.asColorScheme


object PIG {
    val Colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val ColorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = Colors.asColorScheme()

    val Typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}