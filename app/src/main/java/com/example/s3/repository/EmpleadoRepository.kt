package com.example.s3.repository

import com.example.s3.api.EmpleadosAPI
import com.example.s3.api.RetrofitInstance


abstract class EmpleadoRepository: EmpleadosAPI {

    suspend fun getAllEmpleados() =
        RetrofitInstance.api.getEmpleados()

    suspend fun searchByEmpleado(name:String) =
        RetrofitInstance.api.getEmpleados()

}