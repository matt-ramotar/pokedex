package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable

/**
 * The base class for a button.
 * @property modifier The modifier to be applied to the button.
 * @property enabled Whether the button should be enabled or disabled.
 */
@Serializable
sealed class Button : Component {

    abstract val modifier: Modifier
    abstract val enabled: Boolean
    abstract val onClick: Action?

    /**
     * A button with a contained style.
     *
     * @property backgroundColor The background color of the button.
     * @property contentColor The content color of the button.
     * @property elevation The elevation of the button.
     * @property shape The shape of the button.
     */

    @Serializable
    data class Contained(
        override val modifier: Modifier,
        override val enabled: Boolean,
        override val onClick: Action?,
        val backgroundColor: Color?,
        val contentColor: Color?,
        val elevation: Dp?,
        val shape: Shape?,
        val children: MutableList<Component> = mutableListOf(),
    ) : Button() {
        fun child(component: Component) {
            children.add(component)
        }
    }


    /**
     * A button with a text style.
     *
     * @property contentColor: Color
     */
    @Serializable
    data class Text(
        override val modifier: Modifier,
        val text: String,
        val contentColor: Color?,
        override val enabled: Boolean,
        override val onClick: Action?,
    ) : Button()
}