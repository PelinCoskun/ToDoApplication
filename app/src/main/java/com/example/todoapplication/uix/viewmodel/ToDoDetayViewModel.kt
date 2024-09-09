package com.example.todoapplication.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ToDoDetayViewModel @Inject constructor(var trepo: ToDoRepository) :ViewModel() {

    fun guncelle(id:Int,name: String) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.guncelle(id,name)
        }
    }
}