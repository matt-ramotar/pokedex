package com.dropbox.pokedex.treehouse.presenter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import app.cash.redwood.LayoutModifier
import com.dropbox.pokedex.common.client.HttpClient
import com.dropbox.pokedex.treehouse.componentbox.*
import com.dropbox.pokedex.treehouse.schema.compose.ContainedButton
import com.dropbox.pokedex.treehouse.schema.widget.ContainedButton
import kotlinx.coroutines.flow.MutableStateFlow


@Composable
fun PokedexGraph(
    httpClient: HttpClient,
    columnProvider: ColumnProvider,
    start: ComponentBoxId = "pokedex",
    content: Map<ForestId, @Composable (slots: Map<TreeId, @Composable () -> Unit>) -> Unit>
) {
    val graph: MutableMap<ComponentBoxId, ComponentBox> = mutableMapOf()
    val componentBoxStateFlow = MutableStateFlow(graph[start])
    val componentBoxState = componentBoxStateFlow.collectAsState()

    fun navigate(to: String) {
        if (graph[to] != null) {
            componentBoxStateFlow.value = graph[to]
        }
    }

    when (val componentBox = componentBoxState.value) {
        is Forest -> componentBox.render(httpClient, columnProvider, ::navigate, content)
        is LinkedForest -> componentBox.render(httpClient, columnProvider, ::navigate)
        is Tree -> componentBox.render(httpClient, columnProvider, ::navigate)
        null -> {}
    }
}


@Composable
fun Forest.render(
    httpClient: HttpClient,
    columnProvider: ColumnProvider,
    navigate: ((to: ComponentBoxId) -> Unit)? = null,
    content: Map<ForestId, @Composable (slots: Map<TreeId, @Composable () -> Unit>) -> Unit>
) {
    val slots = remember { mutableMapOf<TreeId, @Composable () -> Unit>() }

    LaunchedEffect(Unit) {
        trees.forEach { tree ->
            slots[tree.key] = { tree.value.render(httpClient, columnProvider, navigate) }
        }
    }

    content[id]?.invoke(slots)
}

@Composable
fun LinkedForest.render(
    httpClient: HttpClient,
    columnProvider: ColumnProvider,
    navigate: ((to: ComponentBoxId) -> Unit)? = null,
) {
    val nodeStateFlow = MutableStateFlow<LinkedForest.Node>(root)
    val nodeState = nodeStateFlow.collectAsState()

    fun next() {
        nodeStateFlow.value.next?.let {
            nodeStateFlow.value = it
        }
    }

    fun prev() {
        nodeStateFlow.value.prev?.let {
            nodeStateFlow.value = it
        }
    }

    nodeState.value.render(httpClient, columnProvider, navigate, ::next, ::prev)
}

@Composable
fun Button.Contained.render(
    httpClient: HttpClient,
    columnProvider: ColumnProvider,
    navigate: ((to: ComponentBoxId) -> Unit)? = null,
    next: (() -> Unit)? = null,
    prev: (() -> Unit)? = null,
) {
    ContainedButton(
        modifier = this.modifier,
        enabled = this.enabled,
        onClick = this.onClick?.run(navigate, next, prev),
        backgroundColor = this.backgroundColor,
        contentColor = this.contentColor,
        elevation = this.elevation,
        shape = this.shape,
        layoutModifier = LayoutModifier,
        content = {
            this.content.render(httpClient, columnProvider, navigate)
        }
    )

}

@Composable
fun Component.render(
    httpClient: HttpClient,
    columnProvider: ColumnProvider,
    navigate: ((to: ComponentBoxId) -> Unit)? = null,
    next: (() -> Unit)? = null,
    prev: (() -> Unit)? = null,
): Unit = when (this) {
    is Button.Contained -> render(httpClient, columnProvider, navigate, next, prev)
    is Button.Text -> TODO()
    is Text -> TODO()
}

@Composable
fun Tree.render(
    httpClient: HttpClient,
    columnProvider: ColumnProvider,
    navigate: ((to: ComponentBoxId) -> Unit)? = null,
    next: (() -> Unit)? = null,
    prev: (() -> Unit)? = null,
): Unit = root.render(httpClient, columnProvider, navigate)

