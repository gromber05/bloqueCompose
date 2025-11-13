package com.gromber05.bloquecompose.ejercicios

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun Ej11() {
    var showDialog by rememberSaveable { mutableStateOf(false) }
    var hasEnteredMatrix by rememberSaveable { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Elige tu destino", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showDialog = true }) {
            Text("Abrir diálogo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (hasEnteredMatrix) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Sustituye por una imagen real de Morfeo
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF000000)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "MORFEO",
                        color = Color.Green,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Has entrado en Matrix.")
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Elige una pastilla") },
                text = { Text("Pastilla azul: salir.\nPastilla roja: entrar en Matrix.") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                            hasEnteredMatrix = true
                        }
                    ) {
                        Text("Pastilla roja")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                            val activity = context as? ComponentActivity
                            activity?.finish()
                        }
                    ) {

                        Text("Pastilla azul")
                    }
                }
            )
        }
    }
}
