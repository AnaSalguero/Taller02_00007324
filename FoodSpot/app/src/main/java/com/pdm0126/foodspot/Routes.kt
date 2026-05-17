package com.pdm0126.foodspot

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes:NavKey{
    @Serializable
    data object Home : Routes()
    @Serializable
    data class RestaurantDetail(val movieId: Int) : Routes()
    @Serializable
    data object GeneralSearch : Routes()

}