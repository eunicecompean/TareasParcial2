package com.eecc.tareasp2.mercadolibre.viewmodels

import androidx.lifecycle.ViewModel
import com.eecc.tareasp2.R
import com.eecc.tareasp2.mercadolibre.models.Categoria
import com.eecc.tareasp2.mercadolibre.models.Producto

class MarketViewModel: ViewModel() {

    val categorias = listOf(
        Categoria(1, "Tecnología", R.drawable.tecnologia),
        Categoria(2, "Perfumería", R.drawable.perfumeria),
        Categoria(3, "Bolsas", R.drawable.bolsas),
        Categoria(4, "Muebles", R.drawable.muebles),
        Categoria(5, "Deportes", R.drawable.deportes)
    )

    fun getProductos (idCategoria: Int): List<Producto> {
        return when (idCategoria) {
            1 -> listOf(
                Producto("Smartphone Galaxy X", 10500.0f, R.drawable.p1cat1, true, "15% OFF"),
                Producto("Laptop Pro 14\"", 18999.0f, R.drawable.p2cat1, false, null),
                Producto("Audífonos Bluetooth", 799.0f, R.drawable.p3cat1, true, "ENVÍO GRATIS"),
                Producto("Tablet 10.1 HD", 5299.0f, R.drawable.p4cat1, true, null),
                Producto("Teclado Mecánico RGB", 1150.0f, R.drawable.p5cat1, false, "20% OFF")
            )

            2 -> listOf(
                Producto("Perfume Chanel No. 5", 2899.0f, R.drawable.p1cat2, true, "EXCLUSIVO ONLINE"),
                Producto("Agua de colonia Adidas", 299.0f, R.drawable.p2cat2, false, null),
                Producto("Set de perfumes miniatura", 899.0f, R.drawable.p3cat2, true, null),
                Producto("Dior Sauvage", 3750.0f, R.drawable.p4cat2, true, "10% OFF"),
                Producto("Body Mist Victoria's Secret", 479.0f, R.drawable.p5cat2, false, null)
            )

            3 -> listOf(
                Producto("Bolsa Michael Kors", 4500.0f, R.drawable.p1cat3, true, "DESCUENTO LIMITADO"),
                Producto("Bolsa Tote Rosa", 1150.0f, R.drawable.p2cat3, false, null),
                Producto("Clutch Elegante", 890.0f, R.drawable.p3cat3, true, null),
                Producto("Bolsa de mano negra", 1299.0f, R.drawable.p4cat3, false, "30% OFF"),
                Producto("Mochila casual", 699.0f, R.drawable.p5cat3, true, null)
            )

            4 -> listOf(
                Producto("Silla ergonómica", 1999.0f, R.drawable.p1cat4, true, "ENVÍO GRATIS"),
                Producto("Sofá cama moderno", 8799.0f, R.drawable.p2cat4, false, null),
                Producto("Escritorio de madera", 3250.0f, R.drawable.p3cat4, true, "15% OFF"),
                Producto("Buró minimalista", 999.0f, R.drawable.p4cat4, false, null),
                Producto("Mueble de TV", 2290.0f, R.drawable.p5cat4, true, "OFERTA")
            )

            5 -> listOf(
                Producto("Bicicleta de montaña", 7250.0f, R.drawable.p1cat5, true, "ENVÍO GRATIS"),
                Producto("Balón de fútbol", 349.0f, R.drawable.p2cat5, false, null),
                Producto("Guantes de boxeo", 799.0f, R.drawable.p3cat5, true, null),
                Producto("Caminadora curva", 13499.0f, R.drawable.p4cat5, false, "DESCUENTO ESPECIAL"),
                Producto("Mancuernas 10kg", 1150.0f, R.drawable.p5cat5, true, null)
            )

            else -> listOf()
        }

    }
}