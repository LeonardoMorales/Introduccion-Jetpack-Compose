package com.dev.leonardom.introuduccionajetpackcompose.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pantalla2(
    text: String,
    darkMode: MutableState<Boolean>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = TextStyle(color = Color.Black, fontSize = 42.sp, fontWeight = FontWeight.Black)
        )

        Button(
            onClick = {  darkMode.value = !darkMode.value}
        ) {
            Icon(
                imageVector = if(darkMode.value) {
                    Icons.Default.DarkMode
                } else {
                   Icons.Default.LightMode
                },
                contentDescription = "Dark mode Icon"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Toggle Dark Mode")
        }
    }
}