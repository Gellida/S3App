package com.example.s3.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.s3.R
import com.example.s3.models.Empleado

class EmpleadoAdapter: RecyclerView.Adapter<EmpleadoAdapter.EmpleadoViewHolder>(){

    inner class  EmpleadoViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Empleado>(){

        override fun areItemsTheSame(oldItem: Empleado, newItem: Empleado): Boolean {
            return oldItem.empleadoId == newItem.empleadoId
        }

        override fun areContentsTheSame(oldItem: Empleado, newItem: Empleado): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpleadoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_empleados,parent,false)
        return EmpleadoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EmpleadoViewHolder, position: Int) {
        val empleado = differ.currentList[position]

        holder.itemView.findViewById<TextView>(R.id.tvName).text = empleado.empleadoId.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_hola).text = "Nombre: " + empleado.name

        setOnItemClickListener {
            onItemClickListener?.let {
                it(empleado)
            }
        }
    }

    private var onItemClickListener: ((Empleado) -> Unit)? = null

    fun setOnItemClickListener(listener: (Empleado) -> Unit) {
        onItemClickListener = listener
    }
}