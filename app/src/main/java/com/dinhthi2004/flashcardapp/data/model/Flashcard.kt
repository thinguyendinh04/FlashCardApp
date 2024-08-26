package com.dinhthi2004.flashcardapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_flashcard")
data class Flashcard(
    @PrimaryKey(autoGenerate = true)
    val flashcardId: Int,
    val name: String,
    val cardCount: Int = 0
)
