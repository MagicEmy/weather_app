package com.emlicame.weather_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.emlicame.weather_app.ui.screens.CurrentlyScreen
import com.emlicame.weather_app.ui.theme.Weather_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Weather_appTheme {
                CurrentlyScreen()
            }
        }
    }
}
