package com.eecc.tareasp2.mercadolibre.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eecc.tareasp2.mercadolibre.models.Categoria
import com.eecc.tareasp2.mercadolibre.viewmodels.MarketViewModel

@Composable
fun CategoriasView(navegar: NavController){

    val viewModel: MarketViewModel = viewModel()

    LazyRow (modifier = Modifier.padding(16.dp)) {
        items(viewModel.categorias) { categoria ->
            Card (
                modifier = Modifier.padding(end= 8.dp)
                    .height(120.dp)
                    .width(120.dp)
                    .clickable {
                        navegar.navigate("productos/${categoria.id}")
                    }
            ) {
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(categoria.imagenResId), contentDescription = "Imagen categoria",
                        modifier = Modifier.height(100.dp)
                            .width(100.dp))
                    Text(categoria.nombreCat)
                }

            }

        }

    }
}

@Preview(showBackground = true)
@Composable

fun CategoriasPreview(){
    val nav = rememberNavController()

    CategoriasView(nav)
}