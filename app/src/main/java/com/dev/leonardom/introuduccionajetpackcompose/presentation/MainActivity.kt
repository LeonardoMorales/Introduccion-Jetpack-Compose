package com.dev.leonardom.introuduccionajetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations.*
import com.dev.leonardom.introuduccionajetpackcompose.navigation.NavigationHost
import com.dev.leonardom.introuduccionajetpackcompose.presentation.components.BottomNavigationBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        Pantalla1,
        Pantalla2,
        Pantalla3
    )

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController, items = navigationItems) },
        floatingActionButton = { FloatingActionButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
        } },
        isFloatingActionButtonDocked = false,
        floatingActionButtonPosition = FabPosition.End
    ){
        NavigationHost(navController)
    }
}










