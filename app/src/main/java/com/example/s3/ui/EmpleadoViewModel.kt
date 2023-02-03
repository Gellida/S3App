package com.example.s3.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s3.models.Empleado
import com.example.s3.models.EmpleadosResponse
import com.example.s3.repository.EmpleadoRepository
import com.example.s3.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class EmpleadoViewModel (
    val EmpleadoRepository : EmpleadoRepository
): ViewModel() {

    val Empleados: MutableLiveData<Resource<EmpleadosResponse>> = MutableLiveData()

    init {
        getAllEmpleados()
    }

    fun getAllEmpleados()  = viewModelScope.launch {
        Empleados.postValue(Resource.Loading())
        val response = EmpleadoRepository.getAllEmpleados()

    }

    private fun handleEmpleadosResponse(response: Response<EmpleadosResponse>): Resource<EmpleadosResponse> {
        if (response.isSuccessful){
            response.body()?.let{ resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}