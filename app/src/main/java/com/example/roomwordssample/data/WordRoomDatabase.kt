package com.example.roomwordssample.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}




