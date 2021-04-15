package com.adedom.tictactoe.data.repositories

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import kotlinx.coroutines.flow.Flow

interface DefaultRepository {

    suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity)

    suspend fun getTurnGameLast(): String?

    fun getTurnGameLastFlow(): Flow<String?>

    fun getTicTacToeFlow(): Flow<List<TicTacToeEntity>>

    suspend fun deleteTicTacToe()

}
