package com.eecc.tareasp2.mercadolibre

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eecc.tareasp2.mercadolibre.views.CategoriasView
import com.eecc.tareasp2.mercadolibre.views.ProductosView

@Preview(showBackground = true)
@Composable

fun NavHostMKT() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "categorias"){
        composable(route = "categorias"){
            CategoriasView(navController)
        }

        composable(route = "productos/{idCategoria}",
            arguments = listOf
                (navArgument("idCategoria") {type =NavType.IntType})
        ) { backStackEntry ->
            val idCategoria = backStackEntry.arguments?.getInt("idCategoria") ?: 0
            ProductosView(idCategoria, navController)
        }
    }
}