package com.adedom.tictactoe.data.source

import com.adedom.tictactoe.data.db.AppDatabase
import com.adedom.tictactoe.data.db.entities.TicTacToeEntity

class DefaultDataSourceImpl(
    private val db: AppDatabase,
) : DefaultDataSource {

    override suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity) {
        return db.getTicTacToeDao().saveTicTacToe(ticTacToeEntity)
    }

}
