package com.eecc.tareasp2.t3Nav.views

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eecc.tareasp2.R
import kotlinx.coroutines.delay

@SuppressLint("RememberReturnType")
@Composable

fun RespuestaView(nombre: String, id: Int) {

    var isLoading by remember {
        mutableStateOf(true)
    }

    var mensaje by remember {
        mutableStateOf("")
    }

    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    val borderWidth = 4.dp

    var guardar by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        delay(3000)
        mensaje = when {
            id in 1..10 -> "Bienvenido al laboratorio de ISND estimado Coordinador $nombre"
            id in 11..100 -> "Permiso autorizado para el profesor $nombre"
            id in 101..19000 -> "Acceso denegado a egresados que no son de sistemas."
            id in 19001..22210 && id != 22180 -> "Bienvenido $nombre, es un gusto verlo por aquí."
            id == 22180 -> "Alumno en intercambio no es posible esté presente en el I.E.ST."
            else -> "Este laboratorio es de uso exclusivo para la carrera ISND"
        }
        isLoading = false
    }

    Column (modifier = Modifier.fillMaxSize()
        .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        if (isLoading) {
            CircularProgressIndicator()
        } else {

            Image(painter = painterResource(id = R.drawable.sistemas),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .border(
                        BorderStroke(borderWidth, rainbowColorsBrush),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape))

            Text(text = mensaje,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center)
        }

        Switch(checked = guardar, onCheckedChange = { guardar = it })


    }

}

