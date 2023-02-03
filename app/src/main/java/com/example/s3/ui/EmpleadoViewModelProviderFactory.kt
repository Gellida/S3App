package com.example.s3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.s3.repository.EmpleadoRepository

class EmpleadoViewModelProviderFactory(val empleadoRepository: EmpleadoRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmpleadoViewModel(empleadoRepository) as T
    }

}