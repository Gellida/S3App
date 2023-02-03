package com.example.s3.ui.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s3.R
import com.example.s3.adapters.EmpleadoAdapter
import com.example.s3.ui.EmpleadoViewModel
import com.example.s3.ui.MainActivity
import com.example.s3.utils.Resource

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    lateinit var viewModel: EmpleadoViewModel
    lateinit var EmpleadoAdapter : EmpleadoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        viewModel.Empleados.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()

                    response.data?.let { EmpleadosResponse ->
                        EmpleadoAdapter.differ.submitList(EmpleadosResponse.empleados)

                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "Un error ocurrió")

                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }

            }

        })
    }
    private fun hideProgressBar(){
        ProgressBar.INVISIBLE
    }
    private fun showProgressBar(){
        ProgressBar.VISIBLE
    }

    private fun setupRecyclerView(){
        EmpleadoAdapter = EmpleadoAdapter()

        requireView().findViewById<RecyclerView>(R.id.rvEmpleados).apply {
            adapter = EmpleadoAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


}