package com.example.pawpics.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.pawpics.data.Dog
import com.example.pawpics.viewmodel.DogViewModel

@Composable
fun DogListScreen(viewModel: DogViewModel) {
    val dogs = viewModel.allDogs.observeAsState().value ?: emptyList()
    LazyColumn (
        modifier = Modifier.fillMaxSize()
    ) {
        items(dogs) { dog ->
            DogItem(dog = dog)
        }
    }
}

@Composable
fun DogItem(dog: Dog) {
    Text(text = dog.name.toString())
}
