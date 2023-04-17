package com.dropbox.pokedex.treehouse.presenter.componentbox.component

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.*

@Composable
fun containedButton(
    modifier: Modifier = Modifier(),
    enabled: Boolean = true,
    onClick: Action? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    elevation: Dp? = null,
    shape: Shape? = null,
    children: @Composable Button.Contained.() -> Unit
): Component = Button.Contained(
    modifier,
    enabled,
    onClick,
    backgroundColor,
    contentColor,
    elevation,
    shape
).apply {
    children()
}
