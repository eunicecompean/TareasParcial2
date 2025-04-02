package com.eecc.tareasp2.datastore.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eecc.tareasp2.datastore.viewmodel.ComidasViewModel

@Composable
fun ResumenView() {
    val viewModel: ComidasViewModel = viewModel()
    val user = viewModel.userData.collectAsState().value

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Nombre: ${user.nombre}")
        Text("Edad: ${user.edad}")
        Text("Altura: ${user.altura}")
        Text("Monedero: $${user.monedero}")
    }
}
