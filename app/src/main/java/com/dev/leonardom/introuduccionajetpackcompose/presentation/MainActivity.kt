package com.dev.leonardom.introuduccionajetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposable()
        }
    }
}

data class Producto(val nombre: String, val precio: Double)

data class Publicidad(val titulo: String)

private val listaProductos = listOf(
    Producto(nombre = "Manzana", precio = 18.99),
    Producto(nombre = "Carne", precio = 180.00),
    Producto(nombre = "Leche", precio = 24.50),
    Producto(nombre = "Pescado", precio = 75.39),
    Producto(nombre = "Huevo", precio = 64.89),
    Producto(nombre = "Cereal", precio = 32.99),
    Producto(nombre = "Naranja", precio = 28.50),
    Producto(nombre = "Café", precio = 72.00),
    Producto(nombre = "Jabón", precio = 33.19),
    Producto(nombre = "Harina", precio = 41.99),
    Producto(nombre = "Aceite", precio = 19.00),
    Producto(nombre = "Agua", precio = 55.99),
    Producto(nombre = "Camisa", precio = 228.49),
    Producto(nombre = "Arroz", precio = 37.50),
    Producto(nombre = "HERSHEY'S", precio = 15.50),
    Producto(nombre = "Miel", precio = 82.00),
    Producto(nombre = "Atún", precio = 16.90),
    Producto(nombre = "Galletas", precio = 41.00),
    Producto(nombre = "Pan", precio = 38.90),
    Producto(nombre = "KitKat", precio = 22.00),
    Producto(nombre = "Nutella", precio = 29.49),
    Producto(nombre = "Crunch", precio = 17.00),
    Producto(nombre = "Panditas", precio = 15.50),
)

private val listaPublicidad = listOf(
    Publicidad("Publicidad 1"),
    Publicidad("Publicidad 2"),
    Publicidad("Publicidad 3"),
    Publicidad("Publicidad 4")
)

@Composable
fun SimpleComposable() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                text = "Productos de Super Mercado",
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black
                )
            )
        }

        /*items(listaProductos) {
            ProductoDiseño(producto = it)
        }*/

        itemsIndexed(listaProductos) { posicion, producto ->
            if(posicion%5 == 0 && posicion != 0) {
                LazyRow {
                    items(listaPublicidad) {
                        PublicidadDiseño(publicidad = it)
                    }
                }
            } else {
                ProductoDiseño(producto = producto)
            }
        }
    }
}

@Composable
fun ProductoDiseño(producto: Producto) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = producto.nombre,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        )

        Text(
            text = "${producto.precio}.00 MXN",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        )
    }
}

@Composable
fun PublicidadDiseño(publicidad: Publicidad) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(140.dp)
            .clip(RoundedCornerShape(12))
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = publicidad.titulo,
            style = TextStyle(
                fontWeight = FontWeight.Black
            )
        )
    }
}










