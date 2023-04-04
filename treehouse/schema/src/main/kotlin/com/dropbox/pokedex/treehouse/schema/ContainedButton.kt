package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Children
import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.dropbox.pokedex.treehouse.componentbox.Color
import com.dropbox.pokedex.treehouse.componentbox.Dp
import com.dropbox.pokedex.treehouse.componentbox.Modifier
import com.dropbox.pokedex.treehouse.componentbox.Shape

@Widget(5)
data class ContainedButton(
    @Property(1) val modifier: Modifier,
    @Property(2) val enabled: Boolean,
    @Property(3) val onClick: () -> Unit,
    @Property(4) val backgroundColor: Color?,
    @Property(5) val contentColor: Color?,
    @Property(6) val elevation: Dp?,
    @Property(7) val shape: Shape?,
    @Children(8) val content: () -> Unit,
)
