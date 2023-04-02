package com.dropbox.pokedex.android.wiring

import android.content.Context
import com.dropbox.pokedex.android.PokedexApp
import com.dropbox.pokedex.android.common.scoping.AppScope
import com.dropbox.pokedex.android.common.scoping.SingleIn
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: PokedexApp,
            @BindsInstance applicationContext: Context,
        ): AppComponent
    }
}