package com.dropbox.pokedex.treehouse.presenter.componentbox.component

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.*

@Composable
fun lazyColumn(
    modifier: Modifier = Modifier(),
    events: Events? = null,
    verticalArrangement: Arrangement.Vertical? = null,
    horizontalAlignment: Alignment.Horizontal? = null,
    contentPaddingValues: PaddingValues? = null,
    children: @Composable LazyColumn.() -> Unit
): Component = LazyColumn(
    modifier,
    events,
    verticalArrangement,
    horizontalAlignment,
    contentPaddingValues
).apply {
    children()
}