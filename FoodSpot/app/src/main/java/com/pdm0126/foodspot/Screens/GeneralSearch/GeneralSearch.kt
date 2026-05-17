package com.pdm0126.foodspot.Screens.GeneralSearch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun GeneralSearch(navigateBack: ()-> Unit,navDetail:(Int)->Unit, viewModel: GeneralSearchViewModel = viewModel()){
    val search by viewModel.search.collectAsState()
    val loading by viewModel.loading.collectAsState()

    var text by remember {
        mutableStateOf("")
    }

    var expanded by rememberSaveable {
        mutableStateOf(false)
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

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            SearchBar(

                query = text,

                onQueryChange = {
                    text = it
                },

                onSearch = {
                    expanded = false
                },

                active = expanded,

                onActiveChange = {
                    expanded = it
                },

                placeholder = {
                    Text("Buscar restaurante")
                },

                modifier = Modifier.align(Alignment.TopCenter)

            ) {

                search.forEach {

                    ListItem(

                        headlineContent = {
                            Text(it.name)
                        },

                        modifier = Modifier.clickable {

                            navDetail(it.id)

                        }
                    )
                }
            }
        }
    }
}