package com.adedom.tictactoe.data.source

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity

interface DefaultDataSource {

    suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity)

    suspend fun getTurnGameLast(): String?

    suspend fun deleteTicTacToe()

}
