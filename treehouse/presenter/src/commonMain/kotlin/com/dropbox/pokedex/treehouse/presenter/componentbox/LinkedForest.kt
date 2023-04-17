package com.dropbox.pokedex.treehouse.presenter.componentbox

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.LinkedForest
import com.dropbox.pokedex.treehouse.componentbox.Tree


@Composable
fun linkedForest(nodes: @Composable LinkedForest.() -> Unit): LinkedForest = LinkedForest().apply {
    nodes()
}

@Composable
fun LinkedForest.node(tree: Tree) {
    val node = LinkedForest.Node(tree)

    if (root == null) {
        root = node
        nodes.add(node)
        return
    }

    val last = nodes.last()
    last.next = node
    node.prev = last
    nodes.add(node)
}