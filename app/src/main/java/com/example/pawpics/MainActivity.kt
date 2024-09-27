package com.example.pawpics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pawpics.view.DogListScreen
import com.example.pawpics.viewmodel.DogViewModel

class MainActivity : ComponentActivity() {

    private val dogViewModel: DogViewModel by viewModels<DogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface (
                modifier = Modifier.fillMaxSize(),
                color = Color.Blue
            ) {
                DogListScreen(viewModel = dogViewModel)
            }
        }
    }
}