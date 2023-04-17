package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable

@Serializable
data class SkeletonLoadingContainer(
    val infiniteTransition: InfiniteTransition.AnimateColor
) : Component

@Serializable
sealed class InfiniteTransition {
    @Serializable
    data class AnimateColor(
        val initialValue: Color,
        val targetValue: Color,
        val animationSpec: InfiniteRepeatableSpec
    )
}


@Serializable
data class InfiniteRepeatableSpec(
    val animation: DurationBasedAnimationSpec,
    val repeatMode: RepeatMode = RepeatMode.Restart,
    val initialStartOffset: StartOffset = StartOffset(0)
)


@Serializable
data class StartOffset(
    val offsetMillis: Int,
    val offsetType: StartOffsetType = StartOffsetType.Delay
)

@Serializable
enum class StartOffsetType {
    Delay,
    FastForward
}

@Serializable
enum class RepeatMode {
    Restart,
    Reverse
}


@Serializable
sealed class DurationBasedAnimationSpec {
    @Serializable
    data class TweenSpec(
        val durationMillis: Long,
        val delay: Int,
        val easing: Easing
    ) : DurationBasedAnimationSpec()

}


@Serializable
sealed class Easing {
    @Serializable
    object Ease : Easing()

    @Serializable
    object EaseIn : Easing()

    @Serializable
    object EaseInBack : Easing()

    @Serializable
    object EaseInOut : Easing()

    @Serializable
    object EaseOut : Easing()

    @Serializable
    object EaseInOutBack : Easing()

    @Serializable
    object FastOutLinearInEasing : Easing()

    @Serializable
    object FastOutSlowInEasing : Easing()

    @Serializable
    object LinearEasing : Easing()

    @Serializable
    object LinearOutSlowInEasing : Easing()
}