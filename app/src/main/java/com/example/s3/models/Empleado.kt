package com.example.s3.models

import androidx.room.Entity

@Entity(
    tableName = "Empleados"
)
data class Empleado(
    val celular_alt: String,
    val curp: String,
    val documentosRequeridos: List<String>,
    val email: String,
    val empleadoId: Int,
    val estadoCivil: String,
    val fatherLastName: String,
    val fechaContratacion: String,
    val fechaNacimiento: String,
    val idempresa: Int,
    val motherLastName: String,
    val name: String,
    val numeroSeguroSocial: String,
    val pagoquincena: Int,
    val password: String,
    val permisos: Int,
    val phoneNumber: String,
    val rfc: String,
    val sexo: String,
    val status: Int,
    val turno: String,
    val userName: String
)