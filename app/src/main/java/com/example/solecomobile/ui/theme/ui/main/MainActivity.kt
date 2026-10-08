package com.example.solecomobile

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.solecomobile.ui.adapter.ProductAdapter
import com.example.solecomobile.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val products = viewModel.getProducts()

        val adapter = ProductAdapter(products) { product ->
            Toast.makeText(
                this,
                "Producto seleccionado: ${product.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        recyclerView.adapter = adapter
    }
}