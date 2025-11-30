package com.emlicame.weather_app.ui.screens

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.emlicame.weather_app.ui.components.MainScreenContent
import com.emlicame.weather_app.ui.navigation.TabItem
import kotlinx.coroutines.launch
/**
* Main screen container managing state for the weather app.
*
* This is the CONTAINER in the Container-Presenter pattern. It manages:
* - Tab selection state
* - Search query state
* - Pager state
* - Event handlers for user interactions
*
* STATE MANAGEMENT:
* - selectedTabIndex: Which tab is currently active (0-2)
* - searchQuery: Current search text or "Geolocation"
* - pagerState: Controls which page is displayed and animations
*
* EVENT HANDLING:
* - Tab clicks: Updates index and animates pager
* - Search text changes: Updates query state
* - Geolocation clicks: Sets query to "Geolocation"
* - Pager swipes: Syncs selected tab index
*/
@Composable
fun MainScreen() {
    // State: Selected tab index (0 = Currently, 1 = Today, 2 = Weekly)
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    // State: Search query or location data; empty = no search active
    var searchQuery by remember { mutableStateOf("") }

    // State: HorizontalPager controller
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { TabItem.allTabs.size } //it's always 3 but to use dynamic expressions for future-proofing
    )

    // Coroutine scope for animations
    val coroutineScope = rememberCoroutineScope ()

    // This effect correctly links the pager's state to the selected tab index. (not during scroll)
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    MainScreenContent(
        selectedTabIndex = selectedTabIndex,
        onTabSelected = { index ->
            selectedTabIndex = index
            coroutineScope.launch {
                pagerState.animateScrollToPage(index)  // animateScrollToPage is a Suspend function, must be in coroutine
            }
        },
        pagerState = pagerState,
        searchQuery = searchQuery,
        onSearchQueryChange = { newQuery ->
            searchQuery = newQuery
        },
        onGeolocationClick = {
            searchQuery = "Geolocation"
        }
    )
}
/**
 * Pattern: Single Source of Truth**
 *
 * User types "Paris" → onSearchQueryChange("Paris")
 *                   → searchQuery = "Paris"
 *                   → Recomposition
 *                   → All screens receive "Paris"
 *                   → All show "Currently Paris", "Today Paris", etc.
 */