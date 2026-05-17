package com.pdm0126.foodspot.Data.Repositories

import com.pdm0126.foodspot.Dummy.sampleRestaurants
import com.pdm0126.foodspot.Model.Restaurant
import kotlinx.coroutines.delay

class RestaurantApiRepository: RestaurantRepository {
    override suspend fun getRestaurants(): List<Restaurant> {
        delay(2000)
        return sampleRestaurants
    }

    override suspend fun getRestaurantByID(id : Int): Restaurant? {
        delay(3000)
        return sampleRestaurants.find { it.id == id }
    }

    override suspend fun getRestaurantBySearch(searchText: String): Restaurant? {
        delay(3000)
        return sampleRestaurants.find { res ->
            res.name.contains(searchText)
                    ||
            res.menu.any{ dish ->
                dish.name.contains(searchText)
            }
        }
    }
    //este quiza no??
    override suspend fun getRestaurantByCategory(category: String): Restaurant? {
        delay(3000)
        return sampleRestaurants.find { res ->
            res.categories.contains(category)
        }
    }
}