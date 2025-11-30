package com.emlicame.weather_app.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.emlicame.weather_app.ui.navigation.TabItem
import com.emlicame.weather_app.ui.screens.CurrentlyScreen
import com.emlicame.weather_app.ui.screens.TodayScreen
import com.emlicame.weather_app.ui.screens.WeeklyScreen

/**
 * Stateless UI component for the main weather screen.
 *
 * This is the PRESENTER in the Container-Presenter pattern.
 * It receives all state as parameters and delegates events upward.
 *
 * ARCHITECTURE:
 * - Stateless: All state comes from parameters
 * - Event delegation: Reports user actions via callbacks
 * - Reusable: Can be used in different contexts (phone, tablet)
 * - Testable: Easy to preview and test with mock data
 *
 * @param selectedTabIndex Currently selected tab (0=Currently, 1=Today, 2=Weekly)
 * @param onTabSelected Callback when user clicks a tab
 * @param pagerState State controlling the horizontal pager
 * @param searchQuery Current search query to display in screens
 * // VERSION 2: Function parameter WITH default value (empty lambda)
 * onSearchQueryChange: (String) -> Unit = {}
 */
@Composable
fun MainScreenContent(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    pagerState: PagerState,
    searchQuery: String,
    // VERSION 1: Function parameter WITHOUT default value
    onSearchQueryChange: (String) -> Unit, // ← REQUIRED parameter
    onGeolocationClick: () -> Unit
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            WeatherTopBar(
                searchQuery = searchQuery,
                onSearchQueryChange = onSearchQueryChange,
                onGeolocationClick = onGeolocationClick
            )
        },
        bottomBar = {
            WeatherBottomNavigation(
                selectedTabIndex = selectedTabIndex,
                onTabSelected = onTabSelected
            )
        }
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { page ->
            when (page) {
                0 -> CurrentlyScreen(searchQuery = searchQuery)
                1 -> TodayScreen(searchQuery = searchQuery)
                2 -> WeeklyScreen(searchQuery = searchQuery)
            }
        }
    }
}
/**
 * Top app bar with search field and geolocation button.
 *
 * COMPONENTS:
 * - TextField: Search input for location queries
 * - IconButton: Simulates geolocation functionality
 *
 * DESIGN DECISIONS:
 * - Search icon as leading icon (visual hint)
 * - No background on TextField (clean Material 3 style)
 * - Location icon button on trailing side
 *
 * @param searchQuery Current text in the search field
 * @param onSearchQueryChange Callback when user types in search field
 * @param onGeolocationClick Callback when location button clicked
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WeatherTopBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onGeolocationClick: () -> Unit
) {
    TopAppBar(
        title = {
            TextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                placeholder = {
                    Text(text = "Search Location...")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        },
        actions = {
            IconButton(
                onClick = onGeolocationClick
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Geolocation Icon - use current location"
                )
            }
        }
    )
}


/**
 * Bottom navigation bar with three weather tabs.
 *
 * Displays a [NavigationBar] with three items corresponding to [TabItem.allTabs].
 * Each item shows an icon and label. The selected tab is highlighted based on
 * [selectedTabIndex].
 *
 * This is a **private helper composable** used only by [MainScreenContent]. It
 * follows the same stateless pattern: receives state, reports events.
 *
 * @param selectedTabIndex Index of the currently selected tab (0-2)
 * @param onTabSelected Callback invoked with the clicked tab's index
 */
@Composable
private fun WeatherBottomNavigation(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    NavigationBar {
        TabItem.Companion.allTabs.forEachIndexed { index, tabItem ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                icon = {
                    Icon(
                        imageVector = tabItem.icon,
                        contentDescription = tabItem.title
                    )
                },
                label = { Text(text = tabItem.title) }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    // For a preview, we create a dummy PagerState
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { TabItem.Companion.allTabs.size }
    )

    MainScreenContent(
        selectedTabIndex = 0,
        onTabSelected = {}, // In a preview, click actions can be empty
        pagerState = pagerState,
        searchQuery = "",
        onSearchQueryChange = {},
        onGeolocationClick = {}
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainScreenWithQueryPreview() {
    // Create another dummy PagerState for this preview
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { TabItem.Companion.allTabs.size }
    )

    MainScreenContent(
        selectedTabIndex = 0,
        onTabSelected = {},
        pagerState = pagerState,
        searchQuery = "Paris", // Provide the specific query for this preview
        onSearchQueryChange = {},
        onGeolocationClick = {}
    )
}

/**
 * @Composable
 * fun AnalyticsButton(
 *     text: String,
 *     onClick: () -> Unit,
 *     onLongClick: () -> Unit = {}  // Optional long-press handling
 * )
 */