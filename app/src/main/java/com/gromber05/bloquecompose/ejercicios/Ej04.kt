package com.gromber05.bloquecompose.ejercicios

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gromber05.bloquecompose.R

@SuppressLint("DiscouragedApi")
@Composable
fun Ej4GalleryWithFavorite() {
    var isFavorite by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Galería de elementos", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(3) { index ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val resourceName = "ej$index"
                    val imageId = context.resources.getIdentifier(
                        resourceName,
                        "drawable",
                        context.packageName
                    )
                    Image(painterResource(
                        id = imageId),
                        contentDescription = "Imagen del ejercicio $index")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        IconButton(onClick = { isFavorite = !isFavorite }) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Marcar como favorito",
                tint = if (isFavorite) Color.Red else Color.Gray
            )
        }

        Text(
            text = if (isFavorite) "Marcado como favorito" else "Pulsa el corazón",
            fontSize = 14.sp
        )
    }
}