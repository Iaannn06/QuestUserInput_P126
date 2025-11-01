package com.example.praktikumpamweek5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.praktikumpamweek5.ui.theme.PraktikumPamWeek5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumPamWeek5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    RegistrationScreen()
                }
            }
        }
    }
}
