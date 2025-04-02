package com.eecc.tareasp2.datastore.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eecc.tareasp2.datastore.models.Usuario
import com.eecc.tareasp2.datastore.viewmodel.ComidasViewModel

@Composable
fun Formulario(navegar: NavController) {
    val viewModel: ComidasViewModel = viewModel()

    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var dinero by remember { mutableStateOf("") }
    var guardar by remember { mutableStateOf(false) }

    Column (modifier = Modifier.padding(16.dp)) {

        Text("Ingresa tus datos", fontSize = 20.sp)

        Text("Ingresa tu nombre:", fontSize = 18.sp)
        TextField(value = nombre, onValueChange = {nombre = it},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF6E4935),
                unfocusedContainerColor = Color(0xFFE3D5C8)
            ))


        Text("Ingresa tu edad:", fontSize = 18.sp)
        TextField(value = edad, onValueChange = {edad = it},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF6E4935),
                unfocusedContainerColor = Color(0xFFE3D5C8)
            ))

        Text("Ingresa tu altura:", fontSize = 18.sp)
        TextField(value = altura, onValueChange = {altura = it},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF6E4935),
                unfocusedContainerColor = Color(0xFFE3D5C8)
            ))

        Text("Ingresa cuanto dinero tienes:", fontSize = 18.sp)
        TextField(value = dinero, onValueChange = {dinero = it},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF6E4935),
                unfocusedContainerColor = Color(0xFFE3D5C8)
            ))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Guardar datos")
            Switch(checked = guardar, onCheckedChange = { guardar = it })
        }

        Button(onClick = {
            if (guardar) {
                val user = Usuario(nombre, edad.toIntOrNull() ?: 0, altura.toFloatOrNull() ?: 0f, dinero.toFloatOrNull() ?: 0f)
                viewModel.guardarUsuario(user)
            }
            navegar.navigate("productos")
        }) {
            Text("Continuar")
        }


    }

}

@Preview(showBackground = true)
@Composable

fun FormularioPreview() {
    val nav = rememberNavController()
    Formulario(nav)
}