package com.dropbox.pokedex.android.common.treehouse.widget

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.cash.redwood.LayoutModifier
import com.dropbox.pokedex.android.common.pig.PIG
import com.dropbox.pokedex.treehouse.componentbox.AnnotatedString
import com.dropbox.pokedex.treehouse.componentbox.Box
import com.dropbox.pokedex.treehouse.componentbox.Button
import com.dropbox.pokedex.treehouse.componentbox.Column
import com.dropbox.pokedex.treehouse.componentbox.Component
import com.dropbox.pokedex.treehouse.componentbox.Forest
import com.dropbox.pokedex.treehouse.componentbox.LazyColumn
import com.dropbox.pokedex.treehouse.componentbox.LinkedForest
import com.dropbox.pokedex.treehouse.componentbox.SkeletonLoadingContainer
import com.dropbox.pokedex.treehouse.componentbox.Text
import com.dropbox.pokedex.treehouse.componentbox.Tree
import com.dropbox.pokedex.treehouse.schema.widget.ComponentBox

internal class PokedexComponentBox : ComponentBox<@Composable () -> Unit> {

    private var componentBox by mutableStateOf<com.dropbox.pokedex.treehouse.componentbox.ComponentBox?>(
        null
    )

    override fun componentBox(componentBox: com.dropbox.pokedex.treehouse.componentbox.ComponentBox) {
        this.componentBox = componentBox
    }

    override var layoutModifiers: LayoutModifier = LayoutModifier

    override val value = @Composable {
        if (this.componentBox != null) {
            this.componentBox!!.Render()
        }
    }

}

@Composable
private fun com.dropbox.pokedex.treehouse.componentbox.ComponentBox.Render() {
    when (this) {
        is Forest -> Render()
        is LinkedForest -> TODO()
        is Tree -> Render()
    }
}

@Composable
private fun Forest.Render() {
    val tile1 = trees["tile1"]
    val tile2 = trees["tile2"]
    val tile3 = trees["tile3"]
    val tile4 = trees["tile4"]

    println(tile1)

    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Column(modifier = Modifier.size(100.dp)) {
                tile1?.Render()
            }

            Spacer(Modifier.width(32.dp))

            Column(modifier = Modifier.size(100.dp)) {
                tile2?.Render()
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Text("Hardcoded Module 1...")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Column(modifier = Modifier.size(100.dp)) {
                tile3?.Render()
            }

            Spacer(Modifier.width(32.dp))


            Column(modifier = Modifier.size(100.dp)) {
                tile4?.Render()
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Text("Hardcoded Module 2...")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Text("Hardcoded Module 3...")
        }
    }

}

@Composable
private fun Tree.Render() {
    root.Render()
}

@Composable
private fun Component.Render() {
    when (this) {
        is AnnotatedString -> TODO()
        is Box -> Render()
        is Button.Contained -> Render()
        is Button.Text -> TODO()
        is Column -> Render()
        is LazyColumn -> TODO()
        is Text -> Render()
        is SkeletonLoadingContainer -> Render()
    }
}

@Composable
private fun Box.Render() {
    Box {
        children.forEach {
            it.Render()
        }
    }
}

@Composable
private fun SkeletonLoadingContainer.Render() {

    SkeletonLoadingContainer {
        val color = LocalSkeletonLoadingColor.current
        Box(
            modifier = Modifier
                .background(color)
                .fillMaxSize()
        )
    }
}

@Composable
private fun Column.Render() {
    Column {
        children.forEach {
            it.Render()
        }
    }
}

@Composable
private fun Text.Render() {
    Text(text ?: "")
}

@Composable
private fun Button.Contained.Render() {
    Row {
        children.forEach {
            it.Render()
        }
    }
}


@Composable
fun SkeletonLoadingContainer(
    content: @Composable () -> Unit,
) {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = PIG.Colors.opacity1.copy(alpha = 0.14f),
        targetValue = PIG.Colors.opacity3.copy(alpha = 0.40f),
        animationSpec = infiniteRepeatable(
            animation = tween(708, easing = LinearEasing),
            repeatMode = androidx.compose.animation.core.RepeatMode.Reverse
        )
    )

    CompositionLocalProvider(
        LocalSkeletonLoadingColor provides color,
        content = content,
    )
}


val LocalSkeletonLoadingColor = staticCompositionLocalOf { Color.Gray }