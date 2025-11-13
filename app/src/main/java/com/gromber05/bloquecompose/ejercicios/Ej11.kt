package com.gromber05.bloquecompose.ejercicios

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gromber05.bloquecompose.R

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
                Image(
                    painter = painterResource(R.drawable.morfeo),
                    contentDescription = "Morfeo, de Matrix",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
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
