package com.pdm0126.foodspot.Screens.RestaurantDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.foodspot.Data.Repositories.RestaurantApiRepository
import com.pdm0126.foodspot.Data.Repositories.RestaurantRepository
import com.pdm0126.foodspot.Model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RestaurantDetailViewModel: ViewModel() {
    private val restaurantRepository: RestaurantRepository = RestaurantApiRepository()

    private val _restaurantbyId = MutableStateFlow<Restaurant?>(null)
    val restaurantById = _restaurantbyId.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    fun loadRestaurantByID (id: Int){
        viewModelScope.launch {
            _loading.value = true
            _restaurantbyId.value = restaurantRepository.getRestaurantByID(id)
        }
    }
}