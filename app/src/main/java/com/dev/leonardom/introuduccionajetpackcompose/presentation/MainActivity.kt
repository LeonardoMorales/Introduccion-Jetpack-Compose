package com.dev.leonardom.introuduccionajetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations.*
import com.dev.leonardom.introuduccionajetpackcompose.navigation.NavigationHost
import com.dev.leonardom.introuduccionajetpackcompose.presentation.components.BottomNavigationBar
import com.dev.leonardom.introuduccionajetpackcompose.presentation.components.Drawer
import com.dev.leonardom.introuduccionajetpackcompose.presentation.components.TopBar

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
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()

    val navigationItems = listOf(
        Pantalla1,
        Pantalla2,
        Pantalla3
    )

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { BottomNavigationBar(navController = navController, items = navigationItems) },
        floatingActionButton = { FloatingActionButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
        } },
        isFloatingActionButtonDocked = false,
        floatingActionButtonPosition = FabPosition.End,
        topBar = { TopBar(scope, scaffoldState ) },
        drawerContent = { Drawer(scope, scaffoldState, navController, items = navigationItems) },
        drawerGesturesEnabled = true
    ){
        NavigationHost(navController)
    }
}










