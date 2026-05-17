package com.pdm0126.foodspot.Screens.GeneralSearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.foodspot.Data.Repositories.RestaurantApiRepository
import com.pdm0126.foodspot.Data.Repositories.RestaurantRepository
import com.pdm0126.foodspot.Model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GeneralSearchViewModel: ViewModel() {
    private val restaurantRepository: RestaurantRepository = RestaurantApiRepository()

    private val _search = MutableStateFlow<List<Restaurant>>(emptyList())
    val search = _search.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    fun loadGeneralSearch(searchVar: String){
        viewModelScope.launch {
            _loading.value = true
            _search.value = restaurantRepository.getRestaurantBySearch(searchVar)
            _loading.value = false
        }
    }
}