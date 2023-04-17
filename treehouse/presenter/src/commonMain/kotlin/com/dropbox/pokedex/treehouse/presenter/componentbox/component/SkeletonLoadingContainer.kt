package com.dropbox.pokedex.treehouse.presenter.componentbox.component

import androidx.compose.runtime.*
import com.dropbox.pokedex.treehouse.componentbox.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


@Composable
fun skeletonLoadingContainer(
    root: Component,
    infiniteTransition: InfiniteTransition.AnimateColor
): SkeletonLoadingContainer = SkeletonLoadingContainer(root, infiniteTransition)


val LocalSkeletonLoadingColor = staticCompositionLocalOf { Color.named("opacity1") }


@Composable
fun infiniteRepeatable(
    initialValue: Color,
    targetValue: Color,
    animationSpec: InfiniteRepeatableSpec
): StateFlow<Color> = MutableStateFlow(initialValue).also { state ->
    LaunchedEffect(initialValue) {
        when (val animation = animationSpec.animation) {
            is DurationBasedAnimationSpec.TweenSpec -> {
                while (true) {
                    delay(animation.durationMillis)
                    if (state.value == initialValue) {
                        state.value = targetValue
                    } else {
                        state.value = initialValue
                    }
                }

            }
        }
    }
}

@Composable
fun SkeletonLoadingContainer(
    content: @Composable () -> Unit,
) {

    val infiniteRepeatableSpec = infiniteRepeatable(
        initialValue = Color.named("opacity1"),
        targetValue = Color.named("opacity3"),
        animationSpec = InfiniteRepeatableSpec(
            animation = DurationBasedAnimationSpec.TweenSpec(
                durationMillis = 10,
                delay = 0,
                easing = Easing.LinearEasing
            )
        )
    )
    val color = remember { infiniteRepeatableSpec }

    CompositionLocalProvider(
        LocalSkeletonLoadingColor provides color.value,
        content = content,
    )
}