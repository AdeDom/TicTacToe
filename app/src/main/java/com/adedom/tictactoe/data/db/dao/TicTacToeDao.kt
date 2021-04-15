package com.adedom.tictactoe.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adedom.tictactoe.data.db.entities.TicTacToeEntity

@Dao
interface TicTacToeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity)

    @Query("SELECT turnGame FROM tic_tac_toe ORDER BY timeMillis DESC LIMIT 1")
    suspend fun getTurnGameLast(): String?

    @Query("DELETE FROM tic_tac_toe")
    suspend fun deleteTicTacToe()

}
