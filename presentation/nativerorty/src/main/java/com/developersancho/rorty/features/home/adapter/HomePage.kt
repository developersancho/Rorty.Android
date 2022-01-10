/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.home.adapter

import com.developersancho.rorty.R

enum class HomePage(
    val position: Int,
    val menuItemId: Int
) {
    CHARACTERS(
        position = 0,
        menuItemId = R.id.charactersFragment
    ),
    FAVORITES(
        position = 1,
        menuItemId = R.id.favoritesFragment
    ),
    SETTINGS(
        position = 2,
        menuItemId = R.id.settingsFragment
    );

    internal companion object {

        fun Int.toHomePageFromPosition(): HomePage {
            return values().find { it.position == this }
                ?: throw IllegalArgumentException("Could not find the main page for the specified position: $this.")
        }

        fun Int.toHomePageMenuItemIdFromPosition(): Int {
            return values().find { it.position == this }?.menuItemId
                ?: throw IllegalArgumentException("Could not find the main page for the specified position: $this.")
        }

        fun Int.toHomePageFromMenuItemId(): HomePage {
            return values().find { it.menuItemId == this }
                ?: throw IllegalArgumentException("Could not find the main page for the specified menu item ID: $this.")
        }
    }
}
