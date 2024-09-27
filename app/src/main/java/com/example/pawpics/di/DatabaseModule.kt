package com.example.pawpics.di

import android.content.Context
import com.example.pawpics.persistence.DogDao
import com.example.pawpics.persistence.DogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DogDatabase {
        return DogDatabase.getDatabase(context)
    }

    @Provides
    fun provideDogsDao(database: DogDatabase): DogDao {
        return database.dogDao()
    }

}