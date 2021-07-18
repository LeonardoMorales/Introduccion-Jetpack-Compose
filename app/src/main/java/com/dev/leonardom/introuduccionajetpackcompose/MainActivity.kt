package com.dev.leonardom.introuduccionajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.leonardom.introuduccionajetpackcompose.ui.theme.IntrouduccionAJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposable()
        }
    }
}

@Composable
fun Figure(color: Color) {
    Box(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
fun SimpleComposable() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Figure(color = Color.Red)
        Figure(color = Color.Green)
        Figure(color = Color.Blue)
    }
}

@Preview(showBackground = true, name = "NuevoNombre", showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    SimpleComposable()
}