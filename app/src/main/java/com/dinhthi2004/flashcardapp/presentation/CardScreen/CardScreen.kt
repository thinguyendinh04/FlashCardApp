package com.dinhthi2004.flashcardapp.presentation.CardScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dinhthi2004.flashcardapp.ui.flashcard.FlashcardViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardScreen(
    navController: NavController,
    flashcardId: String,
    viewModel: FlashcardViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val cards = viewModel.getCardsByFlashcardId(flashcardId).collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Cards",
                        fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black
                    )
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back Screen")
                    }
                },
                actions = {

                    IconButton(onClick = {
                        // Xử lý sự kiện khi bấm MoreVert
                    }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "MoreVert")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
                .background(Color.LightGray)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            cards.value.forEach { card->
                QuestionCard(question = card.flip)
            }
        }
    }
}



