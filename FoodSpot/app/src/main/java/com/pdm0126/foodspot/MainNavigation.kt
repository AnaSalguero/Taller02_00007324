package com.pdm0126.foodspot

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.foodspot.Screens.RestaurantList.RestaurantList
import com.pdm0126.foodspot.Screens.RestaurantDetail.RestaurantDetail
import com.pdm0126.foodspot.Screens.GeneralSearch.GeneralSearch
import com.pdm0126.foodspot.Screens.ShoppingCart.ShoppingCart

@Composable
fun App() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Routes.Home> {
                RestaurantList(
                    navDetail = { restaurantId ->
                        backStack.add(Routes.RestaurantDetail(restaurantId))
                    },
                    navSearch = {
                        backStack.add(Routes.GeneralSearch)
                    },
                    navCart = {
                        backStack.add(Routes.Cart)
                    }
                )
            }
            entry<Routes.RestaurantDetail> { key ->
                RestaurantDetail(
                    restaurantId = key.restaurantId,
                    navigateBack = {
                        backStack.removeLastOrNull()
                    },
                    navCart = {
                        backStack.add(Routes.Cart)
                    }
                )
            }
            entry<Routes.GeneralSearch>{
                GeneralSearch(
                    navigateBack = {
                        backStack.removeLastOrNull()
                    },
                    navDetail = { restaurantId ->
                        backStack.add(Routes.RestaurantDetail(restaurantId))
                    }
                )
            }
            entry< Routes.Cart>{
                ShoppingCart(
                    navigateBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewApp(){
    App()
}