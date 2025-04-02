package com.eecc.tareasp2.t3Nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eecc.tareasp2.t3Nav.views.BienvenidaView
import com.eecc.tareasp2.t3Nav.views.RespuestaView
import com.eecc.tareasp2.t3Nav.views.SesionView

@Preview(showBackground = true)
@Composable

fun NavigationManager () {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "bienvenida") {
        composable(route =  "bienvenida") {
            BienvenidaView(navController)
        }

        composable(route = "sesion") {
            SesionView(navController)
        }

        composable(
            route = "respuesta?nombre={nombre}&id={id}",
            arguments = listOf(
                navArgument("nombre") {
                    type = NavType.StringType
                    defaultValue = "-"
                    nullable = true
                },
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: "-"
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            RespuestaView(nombre, id)
        }


    }
}