package com.dropbox.pokedex.treehouse.presenter.componentbox.component

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.*


@Composable
fun column(
    modifier: Modifier = Modifier(),
    events: Events? = null,
    verticalArrangement: Arrangement.Vertical? = null,
    horizontalAlignment: Alignment.Horizontal? = null,
    children: @Composable Column.() -> Unit
): Component = Column(
    modifier,
    events = events,
    verticalArrangement = verticalArrangement,
    horizontalAlignment = horizontalAlignment
).apply {
    children()
}

@Composable
fun Column.child(component: Component) {
    children.add(component)
}
