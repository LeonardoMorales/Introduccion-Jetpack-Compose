package com.dev.leonardom.introuduccionajetpackcompose.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations.*
import com.dev.leonardom.introuduccionajetpackcompose.navigation.NavigationHost
import com.dev.leonardom.introuduccionajetpackcompose.presentation.components.BottomNavigationBar
import com.dev.leonardom.introuduccionajetpackcompose.presentation.components.Dialog
import com.dev.leonardom.introuduccionajetpackcompose.presentation.components.Drawer
import com.dev.leonardom.introuduccionajetpackcompose.presentation.components.TopBar
import com.dev.leonardom.introuduccionajetpackcompose.ui.theme.BLUE800
import com.dev.leonardom.introuduccionajetpackcompose.ui.theme.IntrouduccionAJetpackComposeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            val darkMode = remember { mutableStateOf(false) }

            SideEffect {
                systemUiController.setStatusBarColor(
                    color = BLUE800
                )
            }

            IntrouduccionAJetpackComposeTheme(
                darkTheme = darkMode.value
            ){
                MainScreen(darkMode)
            }
        }
    }
}


@Composable
fun MainScreen(
    darkMode: MutableState<Boolean>
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()
    val openDialog = remember { mutableStateOf(false) }

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
        topBar = {
            TopBar(
                scope,
                scaffoldState,
                openDialog = { openDialog.value = true  },
                displaySnackBar = {
                    scope.launch {
                        val resultado = scaffoldState.snackbarHostState.showSnackbar(
                            message = "Nuevo SnackBar!",
                            duration = SnackbarDuration.Short,
                            actionLabel = "Aceptar"
                        )

                        when(resultado){
                            SnackbarResult.ActionPerformed -> {
                                Log.d("MainActivity", "Snackbar Accionado")
                            }
                            SnackbarResult.Dismissed -> {
                                Log.d("MainActivity", "Snackbar Ignorado")
                            }
                        }
                    }
                }
            )
       },
        drawerContent = { Drawer(scope, scaffoldState, navController, items = navigationItems) },
        drawerGesturesEnabled = true
    ){
        NavigationHost(navController, darkMode)
    }

    Dialog(showDialog = openDialog.value, dismissDialog = { openDialog.value = false })
}










