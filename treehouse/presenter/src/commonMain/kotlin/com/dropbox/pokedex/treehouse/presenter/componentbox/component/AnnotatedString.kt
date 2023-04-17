package com.dropbox.pokedex.treehouse.presenter.componentbox.component

import com.dropbox.pokedex.treehouse.componentbox.AnnotatedString
import com.dropbox.pokedex.treehouse.componentbox.AnnotatedStringElement
import com.dropbox.pokedex.treehouse.componentbox.Component

fun annotatedString(
    elements: MutableList<AnnotatedStringElement> = mutableListOf()
): Component = AnnotatedString(elements)
