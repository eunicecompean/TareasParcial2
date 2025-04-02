package com.eecc.tareasp2.t3Nav.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eecc.tareasp2.R

@Composable

fun BienvenidaView(navegar: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Image(painter = painterResource(id = R.drawable.iestlogo),
            contentDescription = "")

        Text(text = "Bienvenido al IEST ANÁHUAC",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )

        ExtendedFloatingActionButton(onClick = { navegar.navigate("sesion") },
            modifier = Modifier.fillMaxWidth(),
            text = { Text(text = "Continuar") },
            icon = { Icon(Icons.Filled.Person, contentDescription = "Continuar")},
            containerColor = Color(0xFF613113),
            contentColor = Color.White
        )

    }
}

@Preview(showBackground = true)
@Composable

fun BienvenidaPreview(){

    val nav = rememberNavController()
    BienvenidaView(nav)

}