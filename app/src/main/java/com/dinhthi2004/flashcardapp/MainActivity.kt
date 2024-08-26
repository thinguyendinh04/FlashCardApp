package com.dinhthi2004.flashcardapp

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.dinhthi2004.flashcardapp.data.dao.FlashcardDao
import com.dinhthi2004.flashcardapp.data.database.FlashcardDatabase
import com.dinhthi2004.flashcardapp.navigation.AppNavigation
import com.dinhthi2004.flashcardapp.presentation.FlashCard.FlashCardViewModelFactory
import com.dinhthi2004.flashcardapp.ui.flashcard.FlashcardViewModel
import com.dinhthi2004.flashcardapp.ui.theme.FlashCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashCardAppTheme {
                AppNavigation(rememberNavController())
            }
        }
    }

}


