package com.dinhthi2004.flashcardapp.ui.flashcard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinhthi2004.flashcardapp.data.dao.FlashcardDao
import com.dinhthi2004.flashcardapp.data.model.Flashcard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlashcardViewModel(private val flashcardDao: FlashcardDao) : ViewModel() {

    private val _flashcards = MutableStateFlow<List<Flashcard>>(emptyList())
    val flashcards: StateFlow<List<Flashcard>> get() = _flashcards

    init {
        loadFlashcards()
    }

    private fun loadFlashcards() {
        viewModelScope.launch {
            val flashcardsList = flashcardDao.getAllFlashcards()
            val flashcardsWithCardCount = flashcardsList.map { flashcard ->
                val cardCount = flashcardDao.getCardCountByFlashcardId(flashcard.flashcardId)
                flashcard.copy(cardCount = cardCount)
            }
            _flashcards.value = flashcardsWithCardCount
        }
    }

    fun addFlashcard(flashcard: Flashcard) {
        viewModelScope.launch {
            flashcardDao.insertFlashcard(flashcard)
            loadFlashcards()  // Refresh list after adding
        }
    }

    fun updateFlashcard(flashcard: Flashcard) {
        viewModelScope.launch {
            flashcardDao.updateFlashcard(flashcard)
            loadFlashcards()  // Refresh list after updating
        }
    }

    fun deleteFlashcard(flashcard: Flashcard) {
        viewModelScope.launch {
            flashcardDao.deleteFlashcard(flashcard)
            loadFlashcards()  // Refresh list after deleting
        }
    }

    fun getCardsByFlashcardId(flashcardId: Int) = flow {
        emit(flashcardDao.getAllCardByFlashcardId(flashcardId))
    }
}
