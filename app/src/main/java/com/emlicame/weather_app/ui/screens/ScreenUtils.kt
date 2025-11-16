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

/***
 * public (default): Visible everywhere
 * private: Only visible in this file
 * internal: Only visible within the same module (app)
 * protected: Only visible in subclasses
 */