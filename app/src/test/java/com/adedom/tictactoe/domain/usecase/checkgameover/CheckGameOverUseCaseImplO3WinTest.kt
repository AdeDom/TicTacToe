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

class CheckGameOverUseCaseImplO3WinTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: CheckGameOverUseCase

    @Before
    fun setUp() {
        useCase = CheckGameOverUseCaseImpl(defaultRepository)
    }

    @Test
    fun checkGameOver_checkOTableThreeColumnOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableThreeColumnTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableThreeColumnThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 2, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableThreeRowOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableThreeRowTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableThreeRowThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableThreeOblique1() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableThreeOblique2() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 2, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableThreeOblique3() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableThreeOblique4() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 0, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    private fun assertResult(tictactoes: List<TicTacToeEntity>) {
        val result = useCase.checkGameOver(tictactoes, 3)

        val expected = CheckGameOver(winnerPlayer = "O", gameState = CheckGameOver.GameState.End)
        assertThat(result).isEqualTo(expected)
    }

}
