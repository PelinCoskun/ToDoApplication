package com.example.todoapplication.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoKayitViewModel @Inject constructor(var trepo: ToDoRepository) :ViewModel() {
    fun kaydet(name:String){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.kaydet(name)
        }
    }
}