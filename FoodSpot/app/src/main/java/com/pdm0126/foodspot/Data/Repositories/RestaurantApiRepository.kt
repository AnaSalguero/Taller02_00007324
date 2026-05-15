package com.pdm0126.foodspot.Data.Repositories

import com.pdm0126.foodspot.Dummy.sampleRestaurants
import com.pdm0126.foodspot.Model.Restaurant
import com.pdm0126.foodspot.Model.Dish
import kotlinx.coroutines.delay

class RestaurantApiRepository: RestaurantRepository {
    override suspend fun getRestaurants(): List<Restaurant> {
        delay(2000)
        return sampleRestaurants
    }

    override suspend fun getRestaurantBySearch(searchText: String): Restaurant? {
        delay(5000)
        return sampleRestaurants.find { res ->
            res.name.contains(searchText)
                    ||
            res.menu.any{ dish ->
                dish.name.contains(searchText)
            }
        }
    }
}