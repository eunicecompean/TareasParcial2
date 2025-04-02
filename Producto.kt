package com.eecc.tareasp2.mercadolibre.models

data class Producto(
    val nombre: String,
    val precio: Float,
    val imagenResId: Int,
    val envioGratis: Boolean,
    val promocion: String? = null
)
