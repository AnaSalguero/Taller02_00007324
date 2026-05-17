package com.pdm0126.foodspot.Screens.RestaurantList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun RestaurantList(navDetail: (Int) -> Unit, navSearch: () ->Unit, viewModel: RestaurantListViewModel = viewModel()){

    val restaurants by viewModel.restaurant.collectAsState()
    val loading by viewModel.loading.collectAsState()

    val listCat = mutableSetOf<String>()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("FoodSpot")
                },
                actions = {
                    IconButton(onClick = {navSearch()}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        if (loading) {
            Column(Modifier.fillMaxSize().padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                CircularProgressIndicator()
            }
        }else {
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding).padding(15.dp)
            ) {
                restaurants.forEach { res ->
                    res.categories.forEach{ listCat.add(it) }
                }
                listCat.forEach { cat ->
                    item {
                        Text(text = cat,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(
                                start = 16.dp,
                                top = 12.dp,
                                bottom = 8.dp
                            ))
                    }
                    item{
                        LazyRow(contentPadding = PaddingValues(1.dp)) {
                            items(restaurants.filter{cat in it.categories}) { res ->
                                Card(
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .size(width = 140.dp, height = 170.dp)
                                        .clickable{
                                            navDetail(res.id)
                                        },
                                    shape = RoundedCornerShape(16.dp),
                                ) {
                                    Column {

                                        AsyncImage(
                                            model = res.imageUrl,
                                            contentDescription = res.name,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(135.dp),
                                            contentScale = ContentScale.Crop
                                        )
                                        Text(
                                            text = res.name,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 10.dp),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.bodyMedium
                                        )
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

