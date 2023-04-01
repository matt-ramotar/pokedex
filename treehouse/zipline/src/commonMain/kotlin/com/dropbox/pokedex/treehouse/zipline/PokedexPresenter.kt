package com.dropbox.pokedex.treehouse.zipline

import app.cash.redwood.treehouse.AppService
import app.cash.redwood.treehouse.ZiplineTreehouseUi
import app.cash.zipline.ZiplineService
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("PokedexPresenter", exact = true)
interface PokedexPresenter : AppService, ZiplineService {
    fun launch(): ZiplineTreehouseUi
}