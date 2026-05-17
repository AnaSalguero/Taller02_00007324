package com.pdm0126.foodspot.Screens.RestaurantList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.foodspot.Data.Repositories.RestaurantApiRepository
import com.pdm0126.foodspot.Data.Repositories.RestaurantRepository
import com.pdm0126.foodspot.Model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RestaurantListViewModel: ViewModel() {
    private val restaurantRepository: RestaurantRepository = RestaurantApiRepository()

    private val _restaurant = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurant = _restaurant.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    init {
        loadRestaurant()
    }

    fun loadRestaurant(){
        viewModelScope.launch {
            _loading.value = true
            _restaurant.value = restaurantRepository.getRestaurants()
            _loading.value = false
        }
    }

}