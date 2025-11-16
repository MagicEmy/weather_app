package com.emlicame.weather_app.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.emlicame.weather_app.ui.navigation.TabItem

@Composable
fun MainScreenContent(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    pagerState: PagerState,
    searchQuery: String
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
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
        searchQuery = ""
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
        searchQuery = "Paris" // Provide the specific query for this preview
    )
}