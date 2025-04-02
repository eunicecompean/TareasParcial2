package com.eecc.tareasp2.datastore.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.eecc.tareasp2.datastore.models.Comida
import com.eecc.tareasp2.datastore.viewmodel.ComidasViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon

@Composable
fun ProductosView(navegar: NavController) {
    val viewModel: ComidasViewModel = viewModel()
    val user = viewModel.userData.collectAsState().value
    var dineroActual by remember { mutableStateOf(user.monedero) }

    val productos = listOf(
        Comida(1, "Hamburguesa","", 45f),
        Comida(2, "Pizza", "", 60f),
        Comida(3, "Tacos", "", 30f),
        Comida(4, "Agua", "", 15f),
        Comida(5, "Papas", "",25f)
    )

    Column {
        Text("Dinero disponible: $${dineroActual}", modifier = Modifier.padding(16.dp))

        LazyColumn {
            items(productos) { producto ->
                Card(modifier = Modifier.padding(8.dp)) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("${producto.nombre} - $${producto.precio}")
                        Button(onClick = {
                            if (dineroActual >= producto.precio) {
                                dineroActual -= producto.precio
                            }
                        }) {
                            Text("Comprar")
                        }
                    }
                }
            }

            // EFAB al final
            item {
                Spacer(modifier = Modifier.height(16.dp))
                ExtendedFloatingActionButton(
                    onClick = {
                        navegar.navigate("resumen")
                    },
                    icon = { Icon(Icons.Default.Info, contentDescription = "Info") },
                    text = { Text("Ver datos") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}
