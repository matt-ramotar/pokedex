package com.dropbox.pokedex.treehouse.componentbox


import kotlinx.serialization.Serializable

/**
 * The base class for a button.
 * @property modifier The modifier to be applied to the button.
 * @property enabled Whether the button should be enabled or disabled.
 */
@Serializable
sealed interface Button : Component {

    val modifier: Modifier
    val enabled: Boolean
    val onClick: Action?

    /**
     * A button with a contained style and executable event handler.
     *
     * @property backgroundColor The background color of the button.
     * @property contentColor The content color of the button.
     * @property elevation The elevation of the button.
     * @property shape The shape of the button.
     * @property onClick The callback function to be called when the button is clicked.
     */
    interface Contained : Button {
        val backgroundColor: Color?
        val contentColor: Color?
        val elevation: Dp?
        val shape: Shape?
        val content: Component
    }

    /**
     * A button with a text style and executable event handler.
     *
     * @property contentColor: Color
     */
    interface Text : Button {
        val text: String
        val contentColor: Color?
    }
}