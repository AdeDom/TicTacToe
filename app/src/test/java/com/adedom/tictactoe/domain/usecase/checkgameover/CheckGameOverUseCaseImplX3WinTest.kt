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

class CheckGameOverUseCaseImplX3WinTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: CheckGameOverUseCase

    @Before
    fun setUp() {
        useCase = CheckGameOverUseCaseImpl(defaultRepository)
    }

    @Test
    fun checkGameOver_checkXTableThreeColumnOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableThreeColumnTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 1, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableThreeColumnThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableThreeRowOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableThreeRowTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableThreeRowThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableThreeOblique1() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableThreeOblique2() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableThreeOblique3() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkXTableThreeOblique4() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 2, row = 2, turnGame = "X"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "X"),
            TicTacToeEntity(column = 0, row = 0, turnGame = "X"),
        )

        assertResult(tictactoes)
    }

    private fun assertResult(tictactoes: List<TicTacToeEntity>) {
        val result = useCase.checkGameOver(tictactoes, 3)

        val expected = CheckGameOver(winnerPlayer = "X", gameState = CheckGameOver.GameState.End)
        assertThat(result).isEqualTo(expected)
    }

}
