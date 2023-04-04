package com.dropbox.pokedex.treehouse.zipline

import androidx.compose.runtime.Composable
import app.cash.zipline.ZiplineService
import com.dropbox.pokedex.treehouse.componentbox.ComponentBoxId
import com.dropbox.pokedex.treehouse.componentbox.ForestId
import com.dropbox.pokedex.treehouse.componentbox.TreeId
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("HostApi", exact = true)
interface HostGraphPresenter : ZiplineService {
    val start: ComponentBoxId
    val content: Map<ForestId, @Composable (slots: Map<TreeId, @Composable () -> Unit>) -> Unit>
}
