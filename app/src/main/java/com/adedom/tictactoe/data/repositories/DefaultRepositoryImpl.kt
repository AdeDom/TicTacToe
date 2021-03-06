package com.adedom.tictactoe.data.repositories

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import com.adedom.tictactoe.data.source.DefaultDataSource
import kotlinx.coroutines.flow.Flow

class DefaultRepositoryImpl(
    private val dataSource: DefaultDataSource,
) : DefaultRepository {

    override suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity) {
        return dataSource.saveTicTacToe(ticTacToeEntity)
    }

    override suspend fun getTurnGameLast(): String? {
        return dataSource.getTurnGameLast()
    }

    override fun getTicTacToeFlow(): Flow<List<TicTacToeEntity>> {
        return dataSource.getTicTacToeFlow()
    }

    override suspend fun deleteTicTacToeLast() {
        return dataSource.deleteTicTacToeLast()
    }

    override suspend fun deleteTicTacToe() {
        return dataSource.deleteTicTacToe()
    }

    override suspend fun saveWinnerGame(winnerGameEntity: WinnerGameEntity) {
        return dataSource.saveWinnerGame(winnerGameEntity)
    }

    override fun getWinnerGameFlow(): Flow<List<WinnerGameEntity>> {
        return dataSource.getWinnerGameFlow()
    }

    override suspend fun deleteWinnerGame() {
        return dataSource.deleteWinnerGame()
    }

}
