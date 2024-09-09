package com.example.todoapplication.data.datasource

import com.example.todoapplication.data.entity.ToDo
import com.example.todoapplication.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tdao: ToDoDao) {
    suspend fun kaydet(name: String) {
        val yeniToDo= ToDo(0,name)
        tdao.kaydet(yeniToDo)
    }
    suspend fun guncelle(id: Int, name: String) {
        val guncellenecekToDo= ToDo(id,name)
        tdao.guncelle(guncellenecekToDo)
    }
    suspend fun sil(id: Int) {
        val silinecekToDo= ToDo(id,"")
        tdao.sil(silinecekToDo)
    }
    suspend fun toDoYukle(): List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext tdao.toDoYukle()
    }
    suspend fun ara(aramaKelimesi: String): List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext tdao.ara(aramaKelimesi)
    }

}