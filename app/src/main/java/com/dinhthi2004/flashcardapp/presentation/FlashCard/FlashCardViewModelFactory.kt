package com.dinhthi2004.flashcardapp.presentation.FlashCard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dinhthi2004.flashcardapp.data.dao.FlashcardDao
import com.dinhthi2004.flashcardapp.ui.flashcard.FlashcardViewModel

class FlashCardViewModelFactory(
    private val flashcardDao: FlashcardDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlashcardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FlashcardViewModel(flashcardDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}