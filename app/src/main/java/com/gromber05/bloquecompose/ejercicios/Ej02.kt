package com.gromber05.bloquecompose.ejercicios

 import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ej2() {
    var nombre by rememberSaveable { mutableStateOf("") }
    var correo by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var showErrors by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    val nombreVacio = showErrors && nombre.isBlank()
    val correoVacio = showErrors && correo.isBlank()
    val passVacia = showErrors && password.isBlank()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            isError = nombreVacio,
            singleLine = true
        )
        if (nombreVacio) {
            Text(
                text = "El nombre no puede estar vacío",
                color = Color.Red,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth(),
            isError = correoVacio,
            singleLine = true
        )
        if (correoVacio) {
            Text(
                text = "El correo no puede estar vacío",
                color = Color.Red,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            isError = passVacia,
            singleLine = true
        )
        if (passVacia) {
            Text(
                text = "La contraseña no puede estar vacía",
                color = Color.Red,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { if (correo.isBlank() || nombre.isBlank() || password.isBlank()) {
                Toast.makeText(context, "Hay algún campo mal escrito", Toast.LENGTH_SHORT).show()
                showErrors = true
            } else {
                Toast.makeText(context, "Todo en orden", Toast.LENGTH_SHORT).show()
                showErrors = false
            }},
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Validar")
        }
    }
}
