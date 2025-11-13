package com.gromber05.bloquecompose.ejercicios

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Ej8() {
    val opciones = listOf("Tarjeta", "PayPal", "Bizum")
    var seleccion by rememberSaveable { mutableStateOf(opciones.first()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text("Método de pago", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        opciones.forEach { opcion ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (opcion == seleccion),
                        onClick = { seleccion = opcion }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (opcion == seleccion),
                    onClick = { seleccion = opcion }
                )
                Text(opcion)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Seleccionado: $seleccion")
    }
}