package com.emlicame.weather_app.ui.screens
/**
 * Helper function to build display text for screens.
 */
internal fun buildScreenText(screenName: String, query: String): String {
    return if (query.isEmpty()) {
        screenName
    } else {
        "$screenName\n$query"
    }
}
