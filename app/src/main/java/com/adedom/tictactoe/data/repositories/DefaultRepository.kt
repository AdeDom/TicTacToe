package com.adedom.tictactoe.data.repositories

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import kotlinx.coroutines.flow.Flow

interface DefaultRepository {

    suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity)

    suspend fun getTurnGameLast(): String?

    fun getTicTacToeFlow(): Flow<List<TicTacToeEntity>>

    suspend fun deleteTicTacToeLast()

    suspend fun deleteTicTacToe()

    suspend fun saveWinnerGame(winnerGameEntity: WinnerGameEntity)

    fun getWinnerGameFlow(): Flow<List<WinnerGameEntity>>

    suspend fun deleteWinnerGame()

}
