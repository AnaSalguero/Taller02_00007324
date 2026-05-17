package com.pdm0126.foodspot.Screens.RestaurantDetail

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import androidx.compose.runtime.LaunchedEffect
import com.pdm0126.foodspot.Screens.ShoppingCart.ShoppingCartViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun RestaurantDetail(restaurantId: Int, navigateBack: () -> Unit,navCart: () -> Unit, viewModel: RestaurantDetailViewModel = viewModel()){

    val restaurantById by viewModel.restaurantById.collectAsState()
    val loading by viewModel.loading.collectAsState()

    val context = LocalContext.current
    val activity = context as ComponentActivity
    val cartViewModel: ShoppingCartViewModel = viewModel(activity)

    LaunchedEffect(restaurantId) {
        viewModel.loadRestaurantByID(restaurantId)
    }

    restaurantById?.let{
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text(if(loading)"" else it.name)
                    },
                    navigationIcon = {
                        IconButton(onClick = {navigateBack()}) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew,
                                contentDescription = "GoBack"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {navCart()}) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Cart"
                            )
                        }
                    }
                )
            }
        ){innerPadding ->
            if(loading){
                Column(Modifier.fillMaxSize().padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    CircularProgressIndicator()
                }
            }else{
                LazyColumn(Modifier.padding(10.dp).padding(innerPadding)) {
                    item {
                        Text(
                            text = it.description,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    items(it.menu){ dish ->
                        Card( modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                            shape = RoundedCornerShape(18.dp),
                            elevation = CardDefaults.cardElevation(6.dp)
                        ) {

                            Row(
                                modifier = Modifier.fillMaxSize()
                            ) {

                                AsyncImage(
                                    model = dish.imageUrl,
                                    contentDescription = dish.name,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(140.dp)
                                        .padding(10.dp)
                                        .clip(RoundedCornerShape(14.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(12.dp),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {

                                    Text(
                                        text = dish.name,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Text(
                                        text = dish.description,
                                        style = MaterialTheme.typography.bodyMedium,
                                        maxLines = 2
                                    )

                                    Text(
                                        text = "$${dish.price}",
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.SemiBold
                                    )

                                    Button(
                                        onClick = {
                                            cartViewModel.addToCart(dish)
                                            Toast.makeText(
                                                context,
                                                "${dish.name} Agregado al carrito",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        },
                                        contentPadding = PaddingValues(
                                            horizontal = 12.dp,
                                            vertical = 4.dp
                                        ),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Text("+ Agregar")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
