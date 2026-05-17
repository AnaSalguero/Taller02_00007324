package com.pdm0126.foodspot.Screens.ShoppingCart

import androidx.lifecycle.ViewModel
import com.pdm0126.foodspot.Model.Dish
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShoppingCartViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<List<Dish>>(emptyList())
    val cartItems = _cartItems.asStateFlow()

    fun addToCart(dish: Dish) {
        _cartItems.value += dish
    }
    fun clearCart() {
        _cartItems.value = emptyList()
    }
}