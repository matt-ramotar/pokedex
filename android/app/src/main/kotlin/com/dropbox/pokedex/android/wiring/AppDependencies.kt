package com.dropbox.pokedex.android.wiring


import app.cash.redwood.treehouse.TreehouseView
import com.dropbox.pokedex.android.PokedexApp
import com.dropbox.pokedex.android.common.scoping.AppScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppScope::class)
interface AppDependencies {
    val widgets: TreehouseView.WidgetSystem
}