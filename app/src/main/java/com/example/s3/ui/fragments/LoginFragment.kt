package com.example.s3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.s3.R
import com.example.s3.ui.EmpleadoViewModel
import com.example.s3.ui.MainActivity


class LoginFragment : Fragment(R.layout.fragment_login) {

    lateinit var  viewModel: EmpleadoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }



}