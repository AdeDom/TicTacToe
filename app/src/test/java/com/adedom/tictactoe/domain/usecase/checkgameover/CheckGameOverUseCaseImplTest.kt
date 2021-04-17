package com.adedom.tictactoe.domain.usecase.checkgameover

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.repositories.DefaultRepository
import com.adedom.tictactoe.domain.model.CheckGameOver
import com.adedom.tictactoe.domain.usecase.CheckGameOverUseCase
import com.adedom.tictactoe.domain.usecase.CheckGameOverUseCaseImpl
import com.google.common.truth.Truth
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class CheckGameOverUseCaseImplTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: CheckGameOverUseCase

    @Before
    fun setUp() {
        useCase = CheckGameOverUseCaseImpl(defaultRepository)
    }

    @Test
    fun checkGameOver_tableThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
        )

        val result = useCase.checkGameOver(tictactoes, 3)

        val expected = CheckGameOver(
            winnerPlayer = "",
            gameState = CheckGameOver.GameState.Initial,
            turnGame = "O"
        )
        Truth.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun checkGameOver_tableFour() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 0, turnGame = "O"),
        )

        val result = useCase.checkGameOver(tictactoes, 4)

        val expected = CheckGameOver(
            winnerPlayer = "",
            gameState = CheckGameOver.GameState.Initial,
            turnGame = "X"
        )
        Truth.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun checkGameOver_tableFive() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 0, turnGame = "X"),
        )

        val result = useCase.checkGameOver(tictactoes, 5)

        val expected = CheckGameOver(
            winnerPlayer = "",
            gameState = CheckGameOver.GameState.Initial,
            turnGame = "O"
        )
        Truth.assertThat(result).isEqualTo(expected)
    }

}
