package com.adedom.tictactoe.data.repositories

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity

interface DefaultRepository {

    suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity)

}
