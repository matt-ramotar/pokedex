package com.dropbox.pokedex.treehouse.zipline

import app.cash.zipline.ZiplineService
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("HostApi", exact = true)
interface HostApi : ZiplineService {
    suspend fun httpCall(url: String, headers: Map<String, String>): String
}