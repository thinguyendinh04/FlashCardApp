package com.dinhthi2004.flashcardapp.navigation

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dinhthi2004.flashcardapp.presentation.CardScreen.CardScreen
import com.dinhthi2004.flashcardapp.presentation.FlashcardScreen.FlashcardScreen
import com.dinhthi2004.flashcardapp.ui.flashcard.FlashcardViewModel


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "flashcard_screen") {
        composable("flashcard_screen") {
            val viewModel: FlashcardViewModel = viewModel()
            FlashcardScreen(navController, viewModel)
        }
        composable("card_screen/{flashcardId}") { backStackEntry ->
            val flashcardId = backStackEntry.arguments?.getString("flashcardId")
            val viewModel: FlashcardViewModel = viewModel()
            if (flashcardId != null) {
                CardScreen(navController, flashcardId, viewModel)
            } else {
                // Xử lý nếu flashcardId không tồn tại
            }
        }
    }
}