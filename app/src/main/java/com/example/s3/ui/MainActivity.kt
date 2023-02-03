package com.example.s3.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.example.s3.R
import com.example.s3.databinding.ActivityMainBinding
import com.example.s3.repository.EmpleadoRepository

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: EmpleadoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContentView(R.layout.activity_main)
        /**
        val viewModelProviderFactory = EmpleadoViewModelProviderFactory(EmpleadoRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(EmpleadoViewModel::class.java)
        **/
        }
}