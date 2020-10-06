package com.example.roomwordssample.di

import androidx.lifecycle.LiveData
import com.example.roomwordssample.data.Word
import com.example.roomwordssample.data.WordDao
import com.example.roomwordssample.runOnBackgroundThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WordRepository @Inject constructor(private val wordDao: WordDao) {

    private var allWords: LiveData<List<Word>> = wordDao.getAllWords()
    fun getAllWords(): LiveData<List<Word>> {
        return allWords
    }

    fun insert(word: Word) {
        runOnBackgroundThread {
            wordDao.insert(word)
        }
    }
}







