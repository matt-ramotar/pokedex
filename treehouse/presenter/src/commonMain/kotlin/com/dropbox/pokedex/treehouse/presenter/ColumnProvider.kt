package com.dropbox.pokedex.treehouse.presenter

import androidx.compose.runtime.Composable

interface ColumnProvider {
    @Composable
    fun <T> lazy(
        items: List<T>,
        itemContent: @Composable (item: T) -> Unit,
    )
}