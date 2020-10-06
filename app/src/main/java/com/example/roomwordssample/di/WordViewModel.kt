package com.example.roomwordssample.di

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomwordssample.data.Word


class WordViewModel @ViewModelInject constructor( private val repository: WordRepository) :
    ViewModel() {

    val allWords: LiveData<List<Word>> = repository.getAllWords()

    fun insert(word: Word) {
        repository.insert(word)
    }

}