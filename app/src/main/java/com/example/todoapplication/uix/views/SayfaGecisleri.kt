package com.example.todoapplication.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapplication.data.entity.ToDo
import com.example.todoapplication.uix.viewmodel.AnasayfaViewModel
import com.example.todoapplication.uix.viewmodel.ToDoDetayViewModel
import com.example.todoapplication.uix.viewmodel.ToDoKayitViewModel
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(anasayfaViewModel: AnasayfaViewModel,
                   toDoKayitViewModel: ToDoKayitViewModel,
                   toDoDetayViewModel: ToDoDetayViewModel) {
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = "anasayfa"){

        composable("anasayfa"){
            Anasayfa(navController,anasayfaViewModel)
        }
        composable("toDoKayitSayfa"){
            ToDoKayitSayfa(toDoKayitViewModel)
        }
        composable("toDoDetaySayfa/{todo}",
            arguments=listOf(
                navArgument("todo"){ type= NavType.StringType}
            )){
          val json=it.arguments?.getString("todo")
            val nesne=Gson().fromJson(json, ToDo::class.java)

            ToDoDetaySayfa(nesne,toDoDetayViewModel)
        }
    }
}