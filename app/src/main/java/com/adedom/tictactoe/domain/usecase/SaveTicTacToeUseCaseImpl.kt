package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.repositories.DefaultRepository

class SaveTicTacToeUseCaseImpl(
    private val repository: DefaultRepository,
) : SaveTicTacToeUseCase {

    override suspend fun invoke(column: Int, row: Int) {
        val turnGameLast = repository.getTurnGameLast() ?: "O"
        val ticTacToeEntity = TicTacToeEntity(
            column = column,
            row = row,
            turnGame = turnGameNow(turnGameLast),
            timeMillis = System.currentTimeMillis(),
        )
        return repository.saveTicTacToe(ticTacToeEntity)
    }

    override fun turnGameNow(turnGameLast: String): String {
        return if (turnGameLast == "O") "X" else "O"
    }

}
