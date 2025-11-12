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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gromber05.bloquecompose.ejercicios.Ej1WelcomeScreen
import com.gromber05.bloquecompose.ejercicios.Ej2SimpleRegisterForm
import com.gromber05.bloquecompose.ejercicios.Ej3CounterButtons
import com.gromber05.bloquecompose.ejercicios.Ej4GalleryWithFavorite
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
                    Text("Ejercicios3 - Gonzalo Romero Bernal")
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
                0 -> Ej1WelcomeScreen()
                1 -> Ej2SimpleRegisterForm()
                2 -> Ej3CounterButtons()
                3 -> Ej4GalleryWithFavorite()
                4 -> {}
                5 -> {}
                6 -> {}
                7 -> {}
                8 -> {}
                9 -> {}
                10 -> {}
                11 -> {}
                else -> {}
            }
        }
    }
}