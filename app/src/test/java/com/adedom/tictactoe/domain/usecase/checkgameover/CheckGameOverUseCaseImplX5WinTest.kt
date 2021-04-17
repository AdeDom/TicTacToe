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

class CheckGameOverUseCaseImplX5WinTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: CheckGameOverUseCase

    @Before
    fun setUp() {
        useCase = CheckGameOverUseCaseImpl(defaultRepository)
    }

    @Test
    fun checkGameOver_checkXTableFiveColumnOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 4, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveColumnTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 1, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 4, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveColumnThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 4, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveColumnFour() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 3, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 4, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveColumnFive() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 4, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 4, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveRowOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 0, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveRowTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 1, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveRowThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 2, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveRowFour() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 3, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveRowFive() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 4, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 4, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 4, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 4, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 4, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveOblique1() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 4, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveOblique2() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 4, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 4, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveOblique3() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 4, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 4, row = 0, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableFiveOblique4() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 4, row = 4, turnGame = "X"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    private fun assertResult(tictactoes: List<TicTacToeEntity>) {
        val result = useCase.checkGameOver(tictactoes, 5)

        val expected = CheckGameOver(winnerPlayer = "X", gameState = CheckGameOver.GameState.End)
        assertThat(result).isEqualTo(expected)
    }

}
