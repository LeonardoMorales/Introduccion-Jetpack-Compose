package com.dev.leonardom.introuduccionajetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations.*
import com.dev.leonardom.introuduccionajetpackcompose.presentation.Pantalla1
import com.dev.leonardom.introuduccionajetpackcompose.presentation.screens.Pantalla2
import com.dev.leonardom.introuduccionajetpackcompose.presentation.Pantalla3

@Composable
fun NavigationHost(
    navController: NavHostController,
    darkMode: MutableState<Boolean>
) {
    NavHost(navController = navController, startDestination = Pantalla1.route) {
        composable(Pantalla1.route) {
            Pantalla1(
                navegarPantalla2 = { newText ->
                    navController.navigate(Pantalla2.createRoute(newText))
                }
            )
        }

        composable(
            Pantalla2.route,
            arguments = listOf(navArgument("newText"){ defaultValue = "Pantalla 2" })
        ) { navBackStackEntry ->
            var newText = navBackStackEntry.arguments?.getString("newText")
            requireNotNull(newText)
            Pantalla2(newText, darkMode)
        }

        composable(Pantalla3.route) {
            Pantalla3()
        }
    }
}