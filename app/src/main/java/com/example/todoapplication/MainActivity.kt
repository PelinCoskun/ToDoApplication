package com.example.todoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapplication.ui.theme.ToDoApplicationTheme
import com.example.todoapplication.uix.viewmodel.AnasayfaViewModel
import com.example.todoapplication.uix.viewmodel.ToDoDetayViewModel
import com.example.todoapplication.uix.viewmodel.ToDoKayitViewModel
import com.example.todoapplication.uix.views.SayfaGecisleri
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val anasayfaViewModel:AnasayfaViewModel by viewModels()
    val toDoKayitViewModel: ToDoKayitViewModel by viewModels()
    val toDoDetayViewModel: ToDoDetayViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoApplicationTheme {
                SayfaGecisleri(anasayfaViewModel, toDoKayitViewModel, toDoDetayViewModel)
            }
        }
    }
}

