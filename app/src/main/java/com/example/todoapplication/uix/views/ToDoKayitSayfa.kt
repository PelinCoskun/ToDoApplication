package com.example.todoapplication.uix.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todoapplication.uix.viewmodel.ToDoKayitViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoKayitSayfa(toDoKayitViewModel: ToDoKayitViewModel) {
     val tfToDoName= remember { mutableStateOf("") }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "ToDo Kayıt") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TextField(
                value = tfToDoName.value,
                onValueChange = { tfToDoName.value = it },
                label = { Text(text = "ToDo") }
            )

            Button(
                modifier = Modifier.size(250.dp,50.dp),
                onClick = {
                    toDoKayitViewModel.kaydet(tfToDoName.value)
                }) { Text(text = "KAYDET") }
        }
    }
}