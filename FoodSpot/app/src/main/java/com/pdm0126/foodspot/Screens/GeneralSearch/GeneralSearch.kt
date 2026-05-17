package com.pdm0126.foodspot.Screens.GeneralSearch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralSearch(
    navigateBack: () -> Unit,
    navDetail: (Int) -> Unit,
    viewModel: GeneralSearchViewModel = viewModel()
) {

    val search by viewModel.search.collectAsState()
    val loading by viewModel.loading.collectAsState()

    var text by rememberSaveable {
        mutableStateOf("")
    }

    LaunchedEffect(text) {

        if (text.isNotBlank()) {

            viewModel.loadGeneralSearch(text)

        }
    }

    Scaffold(

        topBar = {

            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),

                title = {
                    Text("Buscar")
                },

                navigationIcon = {

                    IconButton(
                        onClick = { navigateBack() }
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "GoBack"
                        )
                    }
                }
            )
        }

    ) { innerPadding ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            item {

                Spacer(modifier = Modifier.height(16.dp))

                SearchBar(

                    modifier = Modifier.fillMaxWidth(),

                    inputField = {

                        SearchBarDefaults.InputField(

                            query = text,

                            onQueryChange = {
                                text = it
                            },

                            onSearch = {},

                            expanded = false,

                            onExpandedChange = {},

                            placeholder = {
                                Text("Buscar restaurante")
                            },

                            leadingIcon = {

                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search"
                                )
                            }
                        )
                    },

                    expanded = false,

                    onExpandedChange = {}

                ) {}

                Spacer(modifier = Modifier.height(20.dp))
            }

            if (loading) {

                item {

                    CircularProgressIndicator()

                }

            } else {

                if (text.isBlank()) {

                    item {

                        Text(
                            text = "Escribe algo para buscar"
                        )
                    }

                } else if (search.isEmpty()) {

                    item {

                        Column(

                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(top = 40.dp)

                        ) {

                            Icon(
                                imageVector = Icons.Default.SearchOff,
                                contentDescription = null,
                                modifier = Modifier.size(70.dp),
                                tint = MaterialTheme.colorScheme.outline
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "No se encontraron resultados",
                                color = MaterialTheme.colorScheme.outline
                            )
                        }
                    }

                } else {

                    item {

                        Text(
                            text = "${search.size} resultados encontrados",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    items(search) {

                        Card(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp)
                                .clickable {

                                    navDetail(it.id)

                                },

                            shape = RoundedCornerShape(16.dp),

                            elevation = CardDefaults.cardElevation(4.dp)

                        ) {

                            Row(
                                modifier = Modifier.padding(12.dp)
                            ) {

                                AsyncImage(

                                    model = it.imageUrl,

                                    contentDescription = it.name,

                                    modifier = Modifier
                                        .size(90.dp)
                                        .clip(RoundedCornerShape(12.dp)),

                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.width(12.dp))

                                Column {

                                    Text(
                                        text = it.name,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = it.description,
                                        style = MaterialTheme.typography.bodyMedium,
                                        maxLines = 2
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = it.categories.firstOrNull() ?: "",
                                        color = MaterialTheme.colorScheme.primary,
                                        style = MaterialTheme.typography.bodySmall
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

