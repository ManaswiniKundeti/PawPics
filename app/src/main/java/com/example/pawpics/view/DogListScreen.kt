package com.example.pawpics.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        dog.imageId?.let { imageId ->
            // Use Coil to load images asynchronously
            val painter =
                rememberAsyncImagePainter(model = "https://cdn2.thedogapi.com/images/$imageId.jpg")
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = dog.name ?: "Unknown")
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Temperament: ${dog.temperament ?: "Unknown"}")
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Life Span: ${dog.life_span ?: "Unknown"}")
    }
}
