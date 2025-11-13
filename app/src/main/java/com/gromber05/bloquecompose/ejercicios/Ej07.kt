package com.gromber05.bloquecompose.ejercicios

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Ej7() {
    val intereses = listOf("Videojuegos", "Música", "Deporte", "Lectura", "Programación")
    var seleccionados by rememberSaveable { mutableStateOf(setOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text("Selecciona tus intereses", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        intereses.forEach { interes ->
            val checked = seleccionados.contains(interes)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        seleccionados =
                            if (checked) seleccionados - interes else seleccionados + interes
                    }
                )
                Text(interes)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = if (seleccionados.isEmpty())
                "No hay intereses seleccionados"
            else
                "Seleccionados: ${seleccionados.joinToString()}",
            fontSize = 14.sp
        )
    }
}
