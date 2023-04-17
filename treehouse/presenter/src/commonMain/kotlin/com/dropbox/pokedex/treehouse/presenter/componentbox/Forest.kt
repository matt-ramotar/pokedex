package com.dropbox.pokedex.treehouse.presenter.componentbox

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.Forest
import com.dropbox.pokedex.treehouse.componentbox.Tree
import com.dropbox.pokedex.treehouse.componentbox.TreeId

@Composable
fun forest(trees: @Composable Forest.() -> Unit): Forest = Forest().apply {
    trees()
}

@Composable
fun Forest.tree(id: TreeId, tree: Tree) {
    trees[id] = tree
}