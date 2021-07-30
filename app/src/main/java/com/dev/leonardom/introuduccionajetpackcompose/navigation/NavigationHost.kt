package com.dev.leonardom.introuduccionajetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations.*
import com.dev.leonardom.introuduccionajetpackcompose.presentation.Pantalla1
import com.dev.leonardom.introuduccionajetpackcompose.presentation.Pantalla2
import com.dev.leonardom.introuduccionajetpackcompose.presentation.Pantalla3

@Composable
fun NavigationHost(
    navController: NavHostController
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
            Pantalla2(newText)
        }

        composable(Pantalla3.route) {
            Pantalla3()
        }
    }
}