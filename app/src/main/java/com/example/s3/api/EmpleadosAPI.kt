package com.example.s3.api

import com.example.s3.models.EmpleadosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface EmpleadosAPI {

    @GET("/empleado/all")
    suspend fun getEmpleados():Response<EmpleadosResponse>

    @POST("/login")
    suspend fun login():Response<EmpleadosResponse>
}