package com.example.formulariopractica.screen

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue

@Composable
fun FormularioScreen() {
    var nombreCliente by remember { mutableStateOf("") }
    var telCliente by remember { mutableStateOf("") }
    val telInt = telCliente.toIntOrNull()
    var direccionCliente by remember { mutableStateOf("") }
    var productoCliente by remember { mutableStateOf("") }
    var cantidadCliente by remember { mutableStateOf("") }
    val cantidadInt = cantidadCliente.toIntOrNull()
    val notasAdicionles by remember { mutableStateOf("") }

    val nombreError = nombreCliente.isBlank() || nombreCliente.length <= 3
    val telError = telCliente.isBlank() || telInt == null || telCliente.length <= 8
    val direccionError = direccionCliente.isBlank()
    val productoError = productoCliente.isBlank()
    val cantidadError = cantidadCliente.isBlank() || cantidadInt == null || cantidadInt < 0
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val formularioValido = !nombreError || !telError || !direccionError || !productoError || !cantidadError









}