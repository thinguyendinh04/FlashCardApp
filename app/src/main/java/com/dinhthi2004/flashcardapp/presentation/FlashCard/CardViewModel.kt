package com.dinhthi2004.flashcardapp.ui.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinhthi2004.flashcardapp.data.dao.FlashcardDao
import com.dinhthi2004.flashcardapp.data.model.Card
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CardViewModel(private val flashcardDao: FlashcardDao) : ViewModel() {

    private val _cards = MutableStateFlow<List<Card>>(emptyList())
    val cards: StateFlow<List<Card>> get() = _cards

    fun loadCards(flashcardId: Int) {
        viewModelScope.launch {
            _cards.value = flashcardDao.getAllCardByFlashcardId(flashcardId)
        }
    }

    fun addCard(card: Card) {
        viewModelScope.launch {
            flashcardDao.insertCard(card)
            // Optionally refresh the list if needed
        }
    }

    fun updateCard(card: Card) {
        viewModelScope.launch {
            flashcardDao.updateCard(card)
            // Optionally refresh the list if needed
        }
    }

    fun deleteCard(card: Card) {
        viewModelScope.launch {
            flashcardDao.deleteCard(card)
            // Optionally refresh the list if needed
        }
    }
}
