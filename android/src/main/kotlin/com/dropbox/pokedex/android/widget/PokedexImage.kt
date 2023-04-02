package com.dropbox.pokedex.android.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import app.cash.redwood.LayoutModifier
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.dropbox.pokedex.treehouse.schema.widget.Image


internal class PokedexImage : Image<@Composable () -> Unit> {
    private var url by mutableStateOf("")

    override var layoutModifiers: LayoutModifier = LayoutModifier

    override val value = @Composable {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            contentDescription = null
        )

    }

    override fun url(url: String) {
        this.url = url
    }
}