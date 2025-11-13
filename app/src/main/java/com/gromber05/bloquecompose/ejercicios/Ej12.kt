package com.gromber05.bloquecompose.ejercicios

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay

/*
He hecho uso de una data class para luego poder hacer la lista y así poder acceder a los valores más fácilmente.
En resumen:
    1. - El label es que el que se muestra en el slider
    2. - El slider escoge una variable numérica, entre 0 y 3
    3. - Según la posición se escoge un objeto dentro de la lista que tengo abajo
    4. - Se acceden a los valores de la lista para luego cuando se registra el usuario
*/
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

    val genders = listOf("Hombre", "Mujer")
    var gender by rememberSaveable { mutableStateOf(genders.first()) }

    var isPublicAccount by rememberSaveable { mutableStateOf(false) }

    var ageRangeIndex by rememberSaveable { mutableStateOf(0f) }

    var showDialog by rememberSaveable { mutableStateOf(false) }
    var showErrors by rememberSaveable { mutableStateOf(false) }
    var isLoading by rememberSaveable { mutableStateOf(false) }

    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val emptyName = showErrors && name.isBlank()
    val emptyEmail = showErrors && email.isBlank()
    val emptyPswd = showErrors && password.isBlank()

    /*
    En esta parte del código hago uso de una variable llamada safeAgeRange para que no sobrepase a la hora de hacer uso del slider
    y se salga de los límites de la lista.
    */
    val safeAgeRange = ageRangeIndex.toInt().coerceIn(0, ageRanges.lastIndex)
    val context = LocalContext.current

    var message by rememberSaveable { mutableStateOf("") }
    /*
    Esta es la corrutina que se lanzará para simular que está cargando cuando la variable isLoading esté en true.
     */
    LaunchedEffect(isLoading) {
        if (isLoading) {
            message = "Enviando..."
            delay(3000)
            isLoading = false
            message = ""
            showDialog = true
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            OutlinedTextField(
                value = name,
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { name = it },
                isError = emptyName,
                singleLine = true
            )
            if (emptyName) {
                Text(
                    text = "El nombre no puede estar vacío",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            OutlinedTextField(
                value = email,
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { email = it },
                isError = emptyEmail,
                singleLine = true
            )
            if (emptyEmail) {
                Text(
                    text = "El correo no puede estar vacío",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            OutlinedTextField(
                value = password,
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { password = it },
                isError = emptyPswd,
                singleLine = true
            )
            if (emptyPswd) {
                Text(
                    text = "La contraseña no puede estar vacía",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(text = "Rango de Edad:")
            Text(
                text = ageRanges[safeAgeRange].label,
                style = MaterialTheme.typography.titleLarge
            )

            Slider(
                value = ageRangeIndex,
                onValueChange = { newValue ->
                    ageRangeIndex = newValue
                },
                valueRange = 0f..(ageRanges.size - 1).toFloat(),
                steps = ageRanges.size - 2
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.8f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        "Género",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    genders.forEach { opcion ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = (opcion == gender),
                                    onClick = { gender = opcion }
                                ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (opcion == gender),
                                onClick = { gender = opcion }
                            )
                            Text(opcion)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Perfil público", modifier = Modifier.weight(1f))
                Switch(
                    checked = isPublicAccount,
                    onCheckedChange = { isPublicAccount = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Aceptar términos", modifier = Modifier.weight(1f))
                Checkbox(
                    checked = termsAccepted,
                    onCheckedChange = { termsAccepted = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }



        item {
            Button(
                onClick = {
                    if (email.isBlank() || name.isBlank() || password.isBlank()) {
                        Toast.makeText(
                            context,
                            "Hay algún campo mal escrito",
                            Toast.LENGTH_SHORT
                        ).show()
                        showErrors = true
                    } else if (!termsAccepted) {
                        Toast.makeText(
                            context,
                            "Debes aceptar los términos",
                            Toast.LENGTH_SHORT
                        ).show()
                        showErrors = true
                    } else isLoading = true
                },
                enabled = !isLoading
            ) {
                Text("Registrar")
            }

            if (isLoading) {
                AlertDialog(
                    onDismissRequest = {},
                    title = { Text("Procesando registro") },
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(24.dp))
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(message.ifBlank { "Enviando datos..." })
                        }
                    },
                    confirmButton = { },
                    dismissButton = { }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            if (showDialog && !isLoading) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("¡Registro completado!") },
                    text = {
                        Text(
                            "Nombre: $name\n" +
                                    "Correo: $email\n" +
                                    "Contraseña: $password\n" +
                                    "Edad: ${ageRanges[safeAgeRange].label}\n" +
                                    "Género: $gender\n" +
                                    "Perfil público: ${if (isPublicAccount) "Sí" else "No"}"
                        )
                    },
                    confirmButton = {
                        Button(onClick = { showDialog = false }) {
                            Text("Cerrar")
                        }
                    },
                    dismissButton = {}
                )
            }
        }
    }
}
