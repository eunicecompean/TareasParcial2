package com.eecc.tareasp2.datastore.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eecc.tareasp2.datastore.Preferencias
import com.eecc.tareasp2.datastore.models.Comida
import com.eecc.tareasp2.datastore.models.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class ComidasViewModel(context: Context) : ViewModel() {
    private val preferencias = Preferencias(context) // Tu clase de DataStore

    // Flujo con los datos del usuario guardados en preferencias
    val userData: StateFlow<Usuario> =
        preferencias.userFlow.stateIn(viewModelScope, SharingStarted.Lazily, Usuario("", 0, 0f, 0f))

    //Dinero actual en el monedero (observado desde preferencias)
    private val _dineroActual = MutableStateFlow(0f)
    val dineroActual: StateFlow<Float> = _dineroActual.asStateFlow()

    // Lista de productos disponibles
    val productos = listOf(
        Comida(1, "Pizza","" ,50f),
        Comida(2, "Tacos","", 25f),
        Comida(3, "Hamburguesa","", 60f),
        Comida(4, "Agua", "",15f),
        Comida(5, "Papas","", 30f)
    )

    init {
        // Al iniciar el ViewModel, actualizamos el dinero con el valor de preferencias
        viewModelScope.launch {
            userData.collect { user ->
                _dineroActual.value = user.monedero
            }
        }
    }

    // 4️⃣ Guardar los datos del usuario en preferencias
    fun guardarUsuario(user: Usuario) {
        viewModelScope.launch {
            preferencias.guardarDatos(user)
        }
    }

    // 5️⃣ Comprar producto: solo si hay suficiente dinero
    fun comprar(producto: Comida): Boolean {
        val actual = _dineroActual.value
        return if (actual >= producto.precio) {
            _dineroActual.value = actual - producto.precio
            true
        } else {
            false
        }
    }
}