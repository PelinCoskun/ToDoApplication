package com.example.todoapplication.data.repo

import com.example.todoapplication.data.datasource.ToDoDataSource
import com.example.todoapplication.data.entity.ToDo

class ToDoRepository (var tdds: ToDoDataSource) {
    suspend fun kaydet(name:String) = tdds.kaydet(name)

    suspend fun guncelle(id:Int,name: String) = tdds.guncelle(id,name)

    suspend fun sil(id:Int) = tdds.sil(id)

    suspend fun toDoYukle() : List<ToDo> = tdds.toDoYukle()

    suspend fun ara(aramaKelimesi:String) : List<ToDo> = tdds.ara(aramaKelimesi)
}