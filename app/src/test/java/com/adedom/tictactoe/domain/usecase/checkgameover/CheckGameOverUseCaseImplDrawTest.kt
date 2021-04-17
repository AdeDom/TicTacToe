package com.adedom.tictactoe.domain.usecase.checkgameover

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.repositories.DefaultRepository
import com.adedom.tictactoe.domain.model.CheckGameOver
import com.adedom.tictactoe.domain.usecase.CheckGameOverUseCase
import com.adedom.tictactoe.domain.usecase.CheckGameOverUseCaseImpl
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class CheckGameOverUseCaseImplDrawTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: CheckGameOverUseCase

    @Before
    fun setUp() {
        useCase = CheckGameOverUseCaseImpl(defaultRepository)
    }

    @Test
    fun checkGameOver_drawThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
        )

        val result = useCase.checkGameOver(tictactoes, 3)

        val expected = CheckGameOver(winnerPlayer = "XO", gameState = CheckGameOver.GameState.Draw)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun checkGameOver_drawFour() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
        )

        val result = useCase.checkGameOver(tictactoes, 4)

        val expected = CheckGameOver(winnerPlayer = "XO", gameState = CheckGameOver.GameState.Draw)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun checkGameOver_drawFive() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 4, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 4, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 4, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 4, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 4, turnGame = "X"),
        )

        val result = useCase.checkGameOver(tictactoes, 5)

        val expected = CheckGameOver(winnerPlayer = "XO", gameState = CheckGameOver.GameState.Draw)
        assertThat(result).isEqualTo(expected)
    }

}
