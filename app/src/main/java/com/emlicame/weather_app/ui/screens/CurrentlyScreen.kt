package com.emlicame.weather_app.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp

@Composable
fun CurrentlyScreen(
    searchQuery: String = ""
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buildScreenText("Currently", searchQuery),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
    }
}

//Helper function to build display text

private fun buildScreenText(screenName: String, query: String): String {
    return if (query.isEmpty()) {
        screenName
    } else {
        "$screenName\n$query"
    }
}

@PreviewLightDark
@Composable
fun CurrentlyScreenPreview() {
    CurrentlyScreen("San Francisco")
}

@Preview(showBackground = true)
@Composable
fun CurrentlyScreenEmptyPreview() {
    MaterialTheme {
        CurrentlyScreen()
    }
}