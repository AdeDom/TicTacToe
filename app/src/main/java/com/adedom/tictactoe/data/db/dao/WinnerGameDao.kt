package com.adedom.tictactoe.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WinnerGameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWinnerGame(winnerGameEntity: WinnerGameEntity)

    @Query("SELECT * FROM winner_game")
    fun getWinnerGameFlow(): Flow<List<WinnerGameEntity>>

    @Query("DELETE FROM winner_game")
    suspend fun deleteWinnerGame()

}
