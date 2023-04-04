package com.dropbox.pokedex.android.common.treehouse

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import app.cash.redwood.treehouse.AppService
import app.cash.redwood.treehouse.CodeListener
import app.cash.redwood.treehouse.HostConfiguration
import app.cash.redwood.treehouse.TreehouseApp
import app.cash.redwood.treehouse.TreehouseContentSource
import app.cash.redwood.treehouse.TreehouseView
import app.cash.redwood.treehouse.bindWhenReady
import app.cash.redwood.widget.compose.ComposeWidgetChildren
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun <A : AppService> PokedexTreehouseContent(
    treehouseApp: TreehouseApp<A>,
    widgetSystem: TreehouseView.WidgetSystem,
    codeListener: CodeListener = CodeListener(),
    contentSource: TreehouseContentSource<A>,
) {
    val hostConfiguration = HostConfiguration(
        darkMode = isSystemInDarkTheme(),
    )

    val treehouseView = remember(widgetSystem) {
        object : TreehouseView {
            override val children = ComposeWidgetChildren()
            override val hostConfiguration = MutableStateFlow(hostConfiguration)
            override val widgetSystem = widgetSystem
            override val readyForContent = true
            override var readyForContentChangeListener: TreehouseView.ReadyForContentChangeListener? =
                null

            override fun reset() = children.remove(0, children.widgets.size)
        }
    }
    LaunchedEffect(treehouseView, hostConfiguration) {
        treehouseView.hostConfiguration.value = hostConfiguration
    }
    LaunchedEffect(treehouseView, contentSource, codeListener) {
        contentSource.bindWhenReady(treehouseView, treehouseApp, codeListener)
    }

    Box {
        treehouseView.children.render()
    }
}