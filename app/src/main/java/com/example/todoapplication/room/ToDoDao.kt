package com.example.todoapplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapplication.data.entity.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDos")
    suspend fun toDoYukle() : List<ToDo>

    @Insert
    suspend fun kaydet(todo:ToDo)

    @Update
    suspend fun guncelle(todo:ToDo)

    @Delete
    suspend fun sil(todo:ToDo)

    @Query("SELECT * FROM toDos WHERE name like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<ToDo>
}