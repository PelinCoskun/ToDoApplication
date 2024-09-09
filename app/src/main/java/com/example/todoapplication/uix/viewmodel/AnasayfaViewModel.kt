package com.example.todoapplication.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.entity.ToDo
import com.example.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var trepo: ToDoRepository): ViewModel(){
    var toDoListesi = MutableLiveData<List<ToDo>>()

    init {
        toDoYukle()
    }
    fun sil(id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.sil(id)
            toDoYukle()
        }
    }

    fun toDoYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            toDoListesi.value = trepo.toDoYukle()
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDoListesi.value = trepo.ara(aramaKelimesi)
        }
    }
}