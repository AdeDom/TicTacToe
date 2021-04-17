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

class CheckGameOverUseCaseImplX4WinTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: CheckGameOverUseCase

    @Before
    fun setUp() {
        useCase = CheckGameOverUseCaseImpl(defaultRepository)
    }

    @Test
    fun checkGameOver_checkXTableFourColumnOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 3, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourColumnTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 1, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourColumnThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 3, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourColumnFour() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 3, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourRowOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 0, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourRowTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourRowThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 2, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourRowFour() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourOblique1() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourOblique2() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 3, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 3, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourOblique3() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 0, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFourOblique4() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    private fun assertResult(tictactoes: List<TicTacToeEntity>) {
        val result = useCase.checkGameOver(tictactoes, 4)

        val expected = CheckGameOver(winnerPlayer = "X", gameState = CheckGameOver.GameState.End)
        assertThat(result).isEqualTo(expected)
    }

}
