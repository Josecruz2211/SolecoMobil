package com.example.solecomobile.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.solecomobile.R
import com.example.solecomobile.data.model.ProductModel
import java.text.NumberFormat
import java.util.Locale

class ProductAdapter(
    private val productList: List<ProductModel>,
    private val onItemClick: (ProductModel) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // AQUÍ VA EL VAL: Se crea una sola vez para toda la lista
    private val formatoCop = NumberFormat.getCurrencyInstance(Locale("es", "CO")).apply {
        maximumFractionDigits = 0
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Se cambiaron los IDs para que coincidan con los de tu nuevo item_producto.xml
        val tvName: TextView = itemView.findViewById(R.id.tvNombre)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDetalle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // Se cambió android.R.layout.simple_list_item_2 por tu nuevo diseño R.layout.item_producto
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.tvName.text = product.name

        // AQUÍ SE APLICA EL FORMATO AL PRECIO DEL PRODUCTO
        val precioFormateado = formatoCop.format(product.price)
        holder.tvDescription.text = "${product.description} - $precioFormateado"

        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
    }

    override fun getItemCount(): Int = productList.size
}