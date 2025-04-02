package com.eecc.tareasp2.mercadolibre.views

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.eecc.tareasp2.mercadolibre.models.Categoria
import com.eecc.tareasp2.mercadolibre.viewmodels.MarketViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable

fun ProductosView(idCategoria: Int, navegar: NavController){

    val viewModel: MarketViewModel = viewModel()
    val productos = viewModel.getProductos(idCategoria)

    LazyColumn (modifier = Modifier.padding(16.dp)) {
        items(productos) { producto ->
            Card (
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                (Row(modifier = Modifier.padding(8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(painterResource(producto.imagenResId), contentDescription = producto.nombre)
                    Spacer(modifier = Modifier.width(12.dp))

                    Column{
                        Text(text= producto.nombre,
                            fontWeight = FontWeight.SemiBold)
                        
                        Text(
                            text = "$${producto.precio}",
                            color = Color(0xFF008000),
                            fontSize = 14.sp
                        )

                        Text(
                            text = if (producto.envioGratis) "Envío GRATIS" else "Envío con costo",
                            fontSize = 12.sp
                        )

                        if (producto.promocion != null) {
                            Text(
                                text = producto.promocion,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .background (Color.Black)
                                    .padding(horizontal = 4.dp, vertical = 2.dp)
                            )
                        }
                    }

                }
                )
            }

        }

        item {
            Spacer(modifier = Modifier.height(24.dp))

            ExtendedFloatingActionButton(
                onClick = { navegar.navigateUp() },
                text = { Text("Regresar") },
                icon = { Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Regresar") },
                containerColor = Color(0xFF916DD0),
                contentColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp)
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ProductosPreview() {
    val id = 2

    //ProductosView(id)
}