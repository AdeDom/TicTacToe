package com.adedom.tictactoe.data.repositories

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.source.DefaultDataSource

class DefaultRepositoryImpl(
    private val dataSource: DefaultDataSource,
) : DefaultRepository {

    override suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity) {
        return dataSource.saveTicTacToe(ticTacToeEntity)
    }

    override suspend fun getTurnGameLast(): String? {
        return dataSource.getTurnGameLast()
    }

    override suspend fun deleteTicTacToe() {
        return dataSource.deleteTicTacToe()
    }

}
