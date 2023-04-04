package com.dropbox.pokedex.treehouse.zipline

import app.cash.redwood.treehouse.AppService
import app.cash.redwood.treehouse.ZiplineTreehouseUi
import app.cash.zipline.ZiplineService
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("PokedexGraphPresenter", exact = true)
interface PokedexGraphPresenter : AppService, ZiplineService {
    fun launch(): ZiplineTreehouseUi
}