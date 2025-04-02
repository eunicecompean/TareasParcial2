package com.eecc.tareasp2.A5Nav.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eecc.tareasp2.R

@Composable

fun resultadoView(anio: Int) {

    val edad = 2025 - anio

    val(mensaje, imagenRes) = when (edad) {
        in 0..14 -> "Menor de edad" to R.drawable.nino
        15 -> "Mayor de edad en Indonesia pero no en México" to R.drawable.joven
        16 -> "Mayor de edad en Cuba pero no en México" to R.drawable.joven
        17 -> "Mayor de edad en Corea del Norte pero no en México" to R.drawable.joven
        18 -> "Mayor de edad en México y gran parte de Latinoamérica" to R.drawable.joven
        19 -> "Mayor de edad en Corea del Sur" to R.drawable.joven
        20 -> "Mayor de edad en Japón" to R.drawable.joven
        21 -> "Mayor de edad en USA y posiblemente en todo el mundo" to R.drawable.joven
        60 -> "Eres de la tercera edad" to R.drawable.adultomayor
        65 -> "Ya te puedes jubilar" to R.drawable.adultomayor
        else -> "Edad no destacada" to R.drawable.nimodo
    }

    Column (modifier = Modifier.fillMaxSize()
        .padding(50.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {

        Card (modifier = Modifier.padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)) {

            Column (horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = "Tienes $edad años", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Image(painterResource(id = imagenRes), contentDescription = "edad")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = mensaje, fontSize = 20.sp)
            }

        }

    }
}

