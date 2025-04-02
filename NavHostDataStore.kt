package com.eecc.tareasp2.datastore

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eecc.tareasp2.datastore.models.Comida
import com.eecc.tareasp2.datastore.views.Formulario
import com.eecc.tareasp2.datastore.views.ProductosView
import com.eecc.tareasp2.datastore.views.ResumenView

@Preview(showBackground = true)
@Composable
fun NavHostDS() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "preferencias") {
        composable(route = "preferencias") {
            Formulario(navController)
        }
        composable(route = "comidas") {
            ProductosView(navController)
        }

        composable(route = "resumen") {
            ResumenView()
        }
    }

}
