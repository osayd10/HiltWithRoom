package com.example.roomwordssample.di

import android.content.Context
import androidx.room.Room
import com.example.roomwordssample.data.WordDao
import com.example.roomwordssample.data.WordRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): WordRoomDatabase {
        return Room.databaseBuilder(
            appContext,
            WordRoomDatabase::class.java, "word_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideWordDao(database: WordRoomDatabase): WordDao {
        return database.wordDao()
    }
}