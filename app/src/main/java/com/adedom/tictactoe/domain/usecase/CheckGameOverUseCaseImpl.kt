package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.repositories.DefaultRepository
import com.adedom.tictactoe.domain.model.CheckGameOver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CheckGameOverUseCaseImpl(
    private val repository: DefaultRepository,
) : CheckGameOverUseCase {

    override fun invoke(size: Int): Flow<CheckGameOver> {
        return repository.getTicTacToeFlow().map { checkGameOver(it, size) }
    }

    override fun checkGameOver(tictactoes: List<TicTacToeEntity>, size: Int): CheckGameOver {
        var checkGameOver = CheckGameOver()

        var obliqueX1 = 0
        var obliqueX2 = 0
        var obliqueO1 = 0
        var obliqueO2 = 0
        repeat(size) { index ->
            val rowX = tictactoes.filter { it.column == index && it.turnGame == "X" }
            val columnX = tictactoes.filter { it.row == index && it.turnGame == "X" }
            val rowO = tictactoes.filter { it.column == index && it.turnGame == "O" }
            val columnO = tictactoes.filter { it.row == index && it.turnGame == "O" }

            obliqueX1 +=
                tictactoes.filter { it.turnGame == "X" && it.column == index && it.row == index }.size
            obliqueX2 +=
                tictactoes.filter { it.turnGame == "X" && it.row == (size - index) - 1 && it.column == index }.size
            obliqueO1 +=
                tictactoes.filter { it.turnGame == "O" && it.column == index && it.row == index }.size
            obliqueO2 +=
                tictactoes.filter { it.turnGame == "O" && it.row == (size - index) - 1 && it.column == index }.size

            when {
                rowX.size == size || columnX.size == size || obliqueX1 == size || obliqueX2 == size -> {
                    checkGameOver = CheckGameOver("X", CheckGameOver.GameState.End)
                    return@repeat
                }
                rowO.size == size || columnO.size == size || obliqueO1 == size || obliqueO2 == size -> {
                    checkGameOver = CheckGameOver("O", CheckGameOver.GameState.End)
                    return@repeat
                }
            }
        }

        // draw
        if ((size * size) == tictactoes.size) {
            checkGameOver = CheckGameOver("XO", CheckGameOver.GameState.Draw)
        }

        // turn game
        var turnGame = tictactoes.lastOrNull()?.turnGame?.let { if (it == "X") "O" else "X" }

        // turn game on game state end
        if (checkGameOver.gameState != CheckGameOver.GameState.Initial) {
            turnGame = null
        }

        return checkGameOver.copy(turnGame = turnGame)
    }

}
