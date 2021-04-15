package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.repositories.DefaultRepository
import com.adedom.tictactoe.domain.model.CheckGameOver
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CheckGameOverUseCaseImpl(
    private val repository: DefaultRepository,
) : CheckGameOverUseCase {
    override fun invoke(size: Int): Flow<CheckGameOver> {
        return repository.getTicTacToeFlow().map { tictactoes ->
            var checkGameOver = CheckGameOver("", CheckGameOver.GameState.Initial)

            var obliqueX1 = 0
            var obliqueX2 = 0
            var obliqueO1 = 0
            var obliqueO2 = 0
            repeat(size) { index ->
                val rowX = tictactoes.filter { it.column == index && it.turnGame == "X" }
                val rowO = tictactoes.filter { it.column == index && it.turnGame == "O" }
                val columnX = tictactoes.filter { it.row == index && it.turnGame == "X" }
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
                    rowX.size == size -> {
                        checkGameOver = CheckGameOver("X", CheckGameOver.GameState.End)
                    }
                    rowO.size == size -> {
                        checkGameOver = CheckGameOver("O", CheckGameOver.GameState.End)
                    }
                    columnX.size == size -> {
                        checkGameOver = CheckGameOver("X", CheckGameOver.GameState.End)
                    }
                    columnO.size == size -> {
                        checkGameOver = CheckGameOver("O", CheckGameOver.GameState.End)
                    }
                    obliqueX1 == size -> {
                        checkGameOver = CheckGameOver("X", CheckGameOver.GameState.End)
                    }
                    obliqueX2 == size -> {
                        checkGameOver = CheckGameOver("X", CheckGameOver.GameState.End)
                    }
                    obliqueO1 == size -> {
                        checkGameOver = CheckGameOver("O", CheckGameOver.GameState.End)
                    }
                    obliqueO2 == size -> {
                        checkGameOver = CheckGameOver("O", CheckGameOver.GameState.End)
                    }
                }
            }

            if ((size * size) == tictactoes.size) {
                checkGameOver = CheckGameOver("", CheckGameOver.GameState.Draw)
            }

            var turnGame = tictactoes.lastOrNull()?.turnGame
            turnGame = turnGame?.let { if (it == "X") "O" else "X" }
            checkGameOver.copy(turnGame = turnGame)
        }
    }
}
