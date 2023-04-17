package com.dropbox.pokedex.treehouse.presenter.componentbox.component

import androidx.compose.runtime.Composable
import com.dropbox.pokedex.treehouse.componentbox.Color
import com.dropbox.pokedex.treehouse.componentbox.DurationBasedAnimationSpec
import com.dropbox.pokedex.treehouse.componentbox.Easing
import com.dropbox.pokedex.treehouse.componentbox.InfiniteRepeatableSpec
import com.dropbox.pokedex.treehouse.componentbox.InfiniteTransition
import com.dropbox.pokedex.treehouse.componentbox.SkeletonLoadingContainer


@Composable
fun skeletonLoadingContainer(
    infiniteTransition: InfiniteTransition.AnimateColor = InfiniteTransition.AnimateColor(
        initialValue = Color.named("opacity1"),
        targetValue = Color.named("opacity3"),
        animationSpec = InfiniteRepeatableSpec(
            animation = DurationBasedAnimationSpec.TweenSpec(
                708,
                0,
                Easing.LinearEasing
            )
        )
    )
): SkeletonLoadingContainer = SkeletonLoadingContainer(infiniteTransition)