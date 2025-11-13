package com.gromber05.bloquecompose.ejercicios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


data class AgeRange(val min: Int, val max: Int, val label: String)

val ageRanges = listOf(
    AgeRange(1, 17, "1 - 17 años"),
    AgeRange(18, 30, "18 - 30 años"),
    AgeRange(31, 50, "31 - 50 años"),
    AgeRange(51, 99, "51 + años")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ej12() {
    var termsAccepted by rememberSaveable { mutableStateOf(false) }
    var gender by rememberSaveable { mutableStateOf(false) }
    var radioButton by rememberSaveable { mutableStateOf(0) }
    var ageRange by rememberSaveable { mutableStateOf(5f) }

    var showDialog by rememberSaveable { mutableStateOf(false) }

    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = name,
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { password = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Slider(
            value = ageRange,
            onValueChange = { newValue ->
                ageRange = newValue
            },
            valueRange = 0f..(ageRanges.size - 1).toFloat(),
            steps = ageRanges.size - 2
        )

        Text(text = "Rango de Edad:")
        Text(text = ageRanges[(ageRange.toInt()) - 2].label, style = MaterialTheme.typography.titleLarge)

        Button(
            onClick = {
                showDialog = true
            }
        ) { }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("¡Registro completado!") },
                text = { Text("Nombre: $name \nCorreo: $email \nContraseña: $password") },
                confirmButton = {

                },
                dismissButton = {

                }
            )
        }
    }
}

