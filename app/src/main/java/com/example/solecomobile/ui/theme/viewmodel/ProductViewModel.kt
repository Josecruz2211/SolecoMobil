package com.example.solecomobile.viewmodel

import androidx.lifecycle.ViewModel
import com.example.solecomobile.data.model.ProductModel

class ProductViewModel : ViewModel() {

    fun getProducts(): List<ProductModel> {
        return listOf(
            ProductModel(1, "Desinfectante Multiuso", "Galón x 4 Litros", 25000.0, 15),
            ProductModel(2, "Jabón Líquido para Ropa", "Bidón x 20 Litros", 85000.0, 8),
            ProductModel(3, "Limpiador de Pisos Lavanda", "Botella x 1 Litro", 8000.0, 30)
        )
    }
}