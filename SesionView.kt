package com.eecc.tareasp2.t3Nav.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material3.ExtendedFloatingActionButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eecc.tareasp2.R

@Composable

fun SesionView(navegar: NavController){
    var nombre by remember {
        mutableStateOf("")
    }
    var id by remember {
        mutableStateOf("")
    }


    Column (modifier = Modifier.fillMaxSize()
        .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Image(painter = painterResource(id = R.drawable.iestlogo),
            contentDescription = "")

        Text(text = "Bienvenido al IEST ANÁHUAC",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Text(text = "Ingresa tu nombre:",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )

        TextField(value = nombre, onValueChange = {nombre = it},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF6E4935),
                unfocusedContainerColor = Color(0xFFE3D5C8)
            ))

        Text(text = "Ingresa tu ID:",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        TextField(value = id, onValueChange = {id = it},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF6E4935),
                unfocusedContainerColor = Color(0xFFE3D5C8)
            )
        )

        ExtendedFloatingActionButton(onClick = {
            val idNum = id.toIntOrNull() ?: 0
            navegar.navigate("respuesta?nombre=${nombre}&id=${idNum}")},
            //cambiar ruta
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 19.dp),
            text = { Text(text = "Ingresar") },
            icon = { Icon(Icons.Sharp.AccountCircle, contentDescription = "Ingresar") },
            containerColor = Color(0xFF613113),
            contentColor = Color.White,

        )

    }
}

@Preview(showBackground = true)
@Composable

fun SesionPreview() {
    val nav = rememberNavController()
    SesionView(nav)
}