package com.example.todoapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "toDos")
data class ToDo(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "id") @NotNull var id:Int,
                @ColumnInfo(name = "name") @NotNull var name:String, ){
}