package com.example.formulariopractica.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun FormularioScreen() {
    var nombreCliente by remember { mutableStateOf("") }
    var telCliente by remember { mutableStateOf("") }
    val telInt = telCliente.toIntOrNull()
    var direccionCliente by remember { mutableStateOf("") }
    var productoCliente by remember { mutableStateOf("") }
    var cantidadCliente by remember { mutableStateOf("") }
    val cantidadInt = cantidadCliente.toIntOrNull()
    var notasAdicionales by remember { mutableStateOf("") }

    val nombreError = nombreCliente.isBlank() || nombreCliente.length <= 3
    val telError = telCliente.isBlank() || telInt == null || telCliente.length < 8
    val direccionError = direccionCliente.isBlank()
    val productoError = productoCliente.isBlank()
    val cantidadError = cantidadCliente.isBlank() || cantidadInt == null || cantidadInt <= 0
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val formularioValido = !nombreError || !telError || !direccionError || !productoError || !cantidadError


    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState)}
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Text("Formulario de Pedido", style= MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = nombreCliente   ,
                onValueChange = { nombreCliente = it},
                label = { Text("Nombre")},
                isError = nombreError,
                supportingText = {
                    if (nombreError) {
                        Text("El nombre debe tener al menos 3 letras")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = telCliente,
                onValueChange = { telCliente = it},
                label = { Text("Teléfono")},
                 isError = telError,
                supportingText = {
                    if (telError) {
                        Text("El numero de teléfono debe ser mínimo 8 dígitos y solo contener números")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = direccionCliente,
                onValueChange = { direccionCliente = it},
                label = { Text("Dirección")},
                isError = direccionError,
                supportingText = {
                    if (direccionError) {
                        Text("La dirección no puede estar vacía")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = productoCliente,
                onValueChange = { productoCliente = it},
                label = { Text("Producto")},
                isError = productoError,
                supportingText = {
                    if (productoError) {
                        Text("El producto no puede estar vacío")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = cantidadCliente,
                onValueChange = { cantidadCliente = it},
                label = { Text("Cantidad")},
                isError = cantidadError,
                supportingText = {
                    if (cantidadError) {
                        Text("La cantidad debe ser un número positivo")
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = notasAdicionales,
                onValueChange = { notasAdicionales = it},
                label = { Text("Notas Adicionales")},
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button( onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("Formulario enviado correctamente")
                }

            }, enabled = formularioValido)
            {
                Text("Enviar Formulario")
            }

        }

    }

}