package com.example.pawpics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pawpics.view.DogListScreen
import com.example.pawpics.viewmodel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val dogViewModel: DogViewModel by viewModels<DogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // refresh data from network and insert into DB
        dogViewModel.refreshDogs()

        setContent {
            Surface (
                modifier = Modifier.fillMaxSize()
            ) {
                DogListScreen(viewModel = dogViewModel)
            }
        }
    }
}