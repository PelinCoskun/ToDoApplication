package com.example.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.example.todoapplication.data.datasource.ToDoDataSource
import com.example.todoapplication.data.repo.ToDoRepository
import com.example.todoapplication.room.ToDoDao
import com.example.todoapplication.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDoRepository(tdds:ToDoDataSource): ToDoRepository{
        return ToDoRepository(tdds)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(tdao:ToDoDao): ToDoDataSource{
        return ToDoDataSource(tdao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context): ToDoDao{
      val vt=Room.databaseBuilder(context,Veritabani::class.java,"toDos.sqlite")
          .createFromAsset("toDos.sqlite").build()
      return vt.getToDoDao()
    }
}