package com.example.todoapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplication.data.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class Veritabani :RoomDatabase(){

    abstract fun getToDoDao() : ToDoDao
}