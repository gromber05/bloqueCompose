package com.gromber05.bloquecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gromber05.bloquecompose.ejercicios.Ej1
import com.gromber05.bloquecompose.ejercicios.Ej10
import com.gromber05.bloquecompose.ejercicios.Ej11
import com.gromber05.bloquecompose.ejercicios.Ej12
import com.gromber05.bloquecompose.ejercicios.Ej2
import com.gromber05.bloquecompose.ejercicios.Ej3
import com.gromber05.bloquecompose.ejercicios.Ej4
import com.gromber05.bloquecompose.ejercicios.Ej5
import com.gromber05.bloquecompose.ejercicios.Ej6
import com.gromber05.bloquecompose.ejercicios.Ej7
import com.gromber05.bloquecompose.ejercicios.Ej8
import com.gromber05.bloquecompose.ejercicios.Ej9
import com.gromber05.bloquecompose.ui.theme.BloqueComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BloqueComposeTheme {
                AppPrincipal()
            }
        }
    }
}
data class NavItem(val index: Int, val label: String)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppPrincipal() {
    var pantallaPrincipal by rememberSaveable { mutableStateOf(0) }
    val allNavItems = (0..11).map { NavItem(it, "Ej${it + 1}") }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Ejercicio ${pantallaPrincipal + 1} - Gonzalo Romero Bernal")
                })
        },
        bottomBar = {
            BottomAppBar {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(allNavItems) { item ->
                        Button(
                            onClick = { pantallaPrincipal = item.index }
                        ) {
                            Text(item.label)
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            when (pantallaPrincipal) {
                0 -> Ej1()
                1 -> Ej2()
                2 -> Ej3()
                3 -> Ej4()
                4 -> Ej5()
                5 -> Ej6()
                6 -> Ej7()
                7 -> Ej8()
                8 -> Ej9()
                9 -> Ej10()
                10 -> Ej11()
                11 -> Ej12()
                else -> {}
            }
        }
    }
}