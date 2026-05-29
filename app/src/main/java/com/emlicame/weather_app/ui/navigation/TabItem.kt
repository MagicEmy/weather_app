package com.emlicame.weather_app.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CalendarViewWeek

// Sealed class representing the weather app tabs.

sealed class TabItem(
    val title: String,
    val icon: ImageVector,
    val route: String       // Unique identifier for navigation
) {
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
        val allTabs: List<TabItem> =
            listOf(Currently, Today, Weekly)

        fun getByIndex(index: Int): TabItem =
            allTabs.getOrElse(index) { Currently }

        fun getByRoute(route: String): TabItem =
            allTabs.find { it.route == route } ?: Currently
    }
}
