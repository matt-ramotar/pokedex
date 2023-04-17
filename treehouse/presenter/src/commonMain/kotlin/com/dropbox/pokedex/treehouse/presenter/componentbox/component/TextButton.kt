package com.dropbox.pokedex.treehouse.presenter.componentbox.component

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.*


@Composable
fun textButton(
    modifier: Modifier = Modifier(),
    text: String,
    contentColor: Color? = null,
    enabled: Boolean = false,
    onClick: Action? = null,
): Component = Button.Text(modifier, text, contentColor, enabled, onClick)