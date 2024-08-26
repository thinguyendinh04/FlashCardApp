package com.dinhthi2004.flashcardapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_card")
data class Card(
    @PrimaryKey(autoGenerate = true)
    val cardId: Int,
    val flashcardId: Int,
    val front: String,
    val back: String
)
