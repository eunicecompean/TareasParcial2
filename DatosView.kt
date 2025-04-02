package com.eecc.tareasp2.A5Nav.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun ingresoView(navegar: NavController){

    var anioNacimiento by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize()
        .padding(50.dp)
        .background(Color(0xFFE2DCEE)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "Ingresa tu año de nacimiento:",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )

        TextField(value = anioNacimiento, onValueChange = {anioNacimiento = it},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFCE6B8D),
                unfocusedContainerColor = Color(0xFFDABEC8)
            ))

        FloatingActionButton(onClick = {
            val anio = anioNacimiento.toIntOrNull() ?: 0
            navegar.navigate("resultado/$anio")
        },
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 20.dp)
            ) {
            Text("Calcular edad")
        }
    }

}

@Preview(showBackground = true)
@Composable

fun ingresoPreview() {
    val nav = rememberNavController()
    ingresoView(nav)
}