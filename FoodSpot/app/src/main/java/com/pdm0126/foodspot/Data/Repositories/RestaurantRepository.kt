package com.pdm0126.foodspot.Data.Repositories
import com.pdm0126.foodspot.Model.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurants():List<Restaurant>
    suspend fun getRestaurantBySearch(searchText: String): Restaurant?
    suspend fun getRestaurantByCategory(category: String): Restaurant?
}