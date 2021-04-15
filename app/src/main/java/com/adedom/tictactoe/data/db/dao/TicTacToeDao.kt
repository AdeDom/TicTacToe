package com.adedom.tictactoe.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.adedom.tictactoe.data.db.entities.TicTacToeEntity

@Dao
interface TicTacToeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity)

}
