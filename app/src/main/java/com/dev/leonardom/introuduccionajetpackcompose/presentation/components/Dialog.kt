package com.dev.leonardom.introuduccionajetpackcompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dialog(
    showDialog: Boolean,
    dismissDialog: () -> Unit
) {
    if(showDialog){
        AlertDialog(
            onDismissRequest = { },
            title = { Text("Título del Diálogo", style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )) },
            text = {
                Column {
                    Text("Fila 1")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Fila 2")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Fila 3")
                }
            },
            confirmButton = {
                Button(onClick = { dismissDialog() }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = { dismissDialog() }) {
                    Text("Cancelar")
                }
            }
        )
    }
}