package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.layout.RedwoodLayout
import app.cash.redwood.schema.Schema
import app.cash.redwood.schema.Schema.Dependency
import app.cash.redwood.treehouse.lazylayout.RedwoodTreehouseLazyLayout

@Schema(
    members = [
        TextInput::class,
        Text::class,
        Image::class,
        Icon::class,
        ContainedButton::class,
        AnnotatedString::class,
    ],
    dependencies = [
        Dependency(1, RedwoodLayout::class),
        Dependency(2, RedwoodTreehouseLazyLayout::class),
    ],
)
interface Pokedex



