package com.dinhthi2004.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dinhthi2004.flashcardapp.data.model.Card
import com.dinhthi2004.flashcardapp.data.model.Flashcard
import javax.annotation.Nullable

@Dao
interface FlashcardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlashcard(flashcard: Flashcard)

    @Update
    suspend fun updateFlashcard(flashcard: Flashcard)

    @Delete
    suspend fun deleteFlashcard(flashcard: Flashcard)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card: Card)

    @Update
    suspend fun updateCard(card: Card)

    @Delete
    suspend fun deleteCard(card: Card)

    @Query("SELECT * FROM tb_flashcard")
    @Nullable
    suspend fun getAllFlashcards(): List<Flashcard>

    @Query("SELECT * FROM tb_card WHERE flashcardId = :flashcardId")
    @Nullable
    suspend fun getAllCardByFlashcardId(flashcardId: Int): List<Card>

    @Query("SELECT COUNT(*) FROM tb_card WHERE flashcardId = :flashcardId")
    suspend fun getCardCountByFlashcardId(flashcardId: Int): Int
}
