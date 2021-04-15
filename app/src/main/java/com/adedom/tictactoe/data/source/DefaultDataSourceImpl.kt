package com.adedom.tictactoe.data.source

import com.adedom.tictactoe.data.db.AppDatabase
import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import kotlinx.coroutines.flow.Flow

class DefaultDataSourceImpl(
    private val db: AppDatabase,
) : DefaultDataSource {

    override suspend fun saveTicTacToe(ticTacToeEntity: TicTacToeEntity) {
        return db.getTicTacToeDao().saveTicTacToe(ticTacToeEntity)
    }

    override suspend fun getTurnGameLast(): String? {
        return db.getTicTacToeDao().getTurnGameLast()
    }

    override fun getTicTacToeFlow(): Flow<List<TicTacToeEntity>> {
        return db.getTicTacToeDao().getTicTacToeFlow()
    }

    override suspend fun deleteTicTacToeLast() {
        return db.getTicTacToeDao().deleteTicTacToeLast()
    }

    override suspend fun deleteTicTacToe() {
        return db.getTicTacToeDao().deleteTicTacToe()
    }

    override suspend fun saveWinnerGame(winnerGameEntity: WinnerGameEntity) {
        return db.getWinnerGameDao().saveWinnerGame(winnerGameEntity)
    }

    override fun getWinnerGameFlow(): Flow<List<WinnerGameEntity>> {
        return db.getWinnerGameDao().getWinnerGameFlow()
    }

    override suspend fun deleteWinnerGame() {
        return db.getWinnerGameDao().deleteWinnerGame()
    }

}
