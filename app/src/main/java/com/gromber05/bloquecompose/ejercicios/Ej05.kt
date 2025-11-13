package com.gromber05.bloquecompose.ejercicios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Ej5() {
    var isLoading by rememberSaveable { mutableStateOf(false) }
    var message by rememberSaveable { mutableStateOf("Pulsa para iniciar la carga") }

    LaunchedEffect(isLoading) {
        if (isLoading) {
            message = "Cargando..."
            delay(3000)
            isLoading = false
            message = "Carga completada"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(16.dp))
        }

        Text(message)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { if (!isLoading) isLoading = true },
            enabled = !isLoading
        ) {
            Text("Iniciar carga")
        }
    }
}