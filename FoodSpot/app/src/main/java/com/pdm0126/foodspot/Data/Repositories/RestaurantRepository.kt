package com.pdm0126.foodspot.Data.Repositories
import com.pdm0126.foodspot.Model.Dish
import com.pdm0126.foodspot.Model.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurants():List<Restaurant>
    suspend fun getRestaurantByID(id: Int): Restaurant?
    suspend fun getRestaurantBySearch(searchText: String): List<Restaurant>

}