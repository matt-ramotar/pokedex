package com.dropbox.pokedex.treehouse.presenter.componentbox

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.Component
import com.dropbox.pokedex.treehouse.componentbox.Tree

@Composable
fun tree(root: Component): Tree = Tree(root)
