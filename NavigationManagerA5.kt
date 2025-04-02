package com.eecc.tareasp2.A5Nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eecc.tareasp2.A5Nav.views.ingresoView
import com.eecc.tareasp2.A5Nav.views.resultadoView

@Preview(showBackground = true)
@Composable

fun NavigationManager () {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ingreso"){
        composable(route = "ingreso") {
            ingresoView(navController)
        }

        composable(route = "resultado/{anio}",
            arguments = listOf(
                navArgument("anio") { type = NavType.IntType}
            )
        ) { backStackEntry ->
            val anio = backStackEntry.arguments?.getInt("anio") ?: 0
            resultadoView(anio)
        }
    }

}