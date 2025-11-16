package com.emlicame.weather_app.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CalendarViewWeek

/**
 * Sealed class representing the weather app tabs.
 *
 * WHY SEALED CLASS OVER ENUM:
 * 1. Future extensibility - each tab can have unique properties
 * 2. Type safety - compiler ensures exhaustive when expressions
 * 3. Restricted hierarchy - prevents unwanted inheritance
 * 4. Can hold complex state specific to each tab type
 *
 * EXAMPLE OF FUTURE EXTENSIBILITY:
 * - Currently tab might need: refreshInterval, lastUpdated
 * - Today tab might need: selectedHour, hourlyData
 * - Weekly tab might need: selectedDay, extendedForecast
 */

sealed class TabItem(
    val title: String,
    val icon: ImageVector,
    val route: String       // Unique identifier for navigation
) {
    /**
     * Currently tab - shows current weather conditions.
     *
     * data object vs data class:
     * - Use 'data object' when no parameters needed (singleton)
     * - Use 'data class' when parameters needed (multiple instances)
     */
    data object Currently : TabItem(
        "Currently", Icons.Default.Home, "currently"
    )

    data object Today : TabItem(
        "Today", Icons.Default.CalendarToday, "today"
    )

    data object Weekly : TabItem(
        "Weekly", Icons.Default.CalendarViewWeek, "weekly"
    )

    // Helper to get tab by index, safe against out-of-bounds access
    companion object {
        /**
         * All tabs in display order.
         * Immutable list ensures consistency across the app.
         */
        val allTabs: List<TabItem> =
            listOf(Currently, Today, Weekly)

        /**
         * Safe index-based access with fallback.
         * Useful for state restoration and deep linking.
         */
        fun getByIndex(index: Int): TabItem =
            allTabs.getOrElse(index) { Currently }

        /**
         * Get tab by route string (useful for navigation).
         * Returns null if no matching tab found. Caller MUST handle null, making the error visible
         */
//        fun getByRoute(route: String): TabItem? =
//            allTabs.find { it.route == route }
        fun getByRoute(route: String): TabItem =
            allTabs.find { it.route == route } ?: Currently

    }


}
