package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // Llamamos a las funciones de cada componente
                LazyColumnExample()
                LazyRowExample()
                ScaffoldExample()
                FloatingActionButtonExample()
                CardExample()
                CheckboxExample()
                SliderExample()
                TopAppBarExample()
            }
        }
    }
}

@Composable
fun LazyColumnExample() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10) { index ->
            Text(text = "Elemento $index")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyColumn() {
    LazyColumnExample()
}

@Composable
fun LazyRowExample() {
    LazyRow(modifier = Modifier.fillMaxWidth().height(100.dp)) {
        items(10) { index ->
            Text(text = "Elemento $index", modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyRow() {
    LazyRowExample()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Ejemplo Scaffold") }) },
        floatingActionButton = { FloatingActionButton(onClick = { /* Acción */ }) { Text("+") } }
    ) {
        Text("Contenido de la pantalla", modifier = Modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScaffold() {
    ScaffoldExample()
}

// FloatingActionButton: Botón de acción flotante, generalmente usado para acciones importantes en la pantalla.
@Composable
fun FloatingActionButtonExample() {
    FloatingActionButton(onClick = { /* Acción */ }) {
        Text("+")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFloatingActionButton() {
    FloatingActionButtonExample()
}

// Card: Componente visual con esquinas redondeadas y sombra.
@Composable
fun CardExample() {
    Card(modifier = Modifier.padding(16.dp)) {
        Text(text = "Contenido dentro de una tarjeta", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    CardExample()
}

// Checkbox: Componente de selección múltiple.
@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) }
    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCheckbox() {
    CheckboxExample()
}

// Slider: Control deslizante para seleccionar un valor dentro de un rango.
@Composable
fun SliderExample() {
    var sliderValue by remember { mutableStateOf(0f) }
    Slider(
        value = sliderValue,
        onValueChange = { sliderValue = it },
        valueRange = 0f..100f
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSlider() {
    SliderExample()
}

// TopAppBar: Barra de herramientas superior.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    TopAppBar(title = { Text("Título de la AppBar") })
}

@Preview(showBackground = true)
@Composable
fun PreviewTopAppBar() {
    TopAppBarExample()
}