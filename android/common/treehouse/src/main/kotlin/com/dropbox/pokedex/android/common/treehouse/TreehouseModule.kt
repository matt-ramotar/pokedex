package com.dropbox.pokedex.android.common.treehouse

import app.cash.redwood.treehouse.TreehouseApp
import com.dropbox.pokedex.android.common.scoping.AppScope
import com.dropbox.pokedex.treehouse.zipline.PokedexPresenter
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(AppScope::class)
object TreehouseModule {

    @Provides
    fun providePokedexWidgetFactory(treehouseApp: TreehouseApp<PokedexPresenter>):
            AndroidPokedexWidgetFactory<PokedexPresenter> = AndroidPokedexWidgetFactory(treehouseApp)
}