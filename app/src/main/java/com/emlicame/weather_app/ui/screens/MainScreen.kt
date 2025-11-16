package com.emlicame.weather_app.ui.screens

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.emlicame.weather_app.ui.navigation.TabItem
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    searchQuery: String = ""
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { TabItem.allTabs.size } //it's always 3 but to use dynamic expressions for future-proofing
    )

    val coroutineScope = rememberCoroutineScope ()

    // This effect correctly links the pager's state to your tab index.
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
                pagerState.animateScrollToPage(index)
            }
        },
        pagerState = pagerState,
        searchQuery = searchQuery
    )
}
