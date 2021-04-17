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

class CheckGameOverUseCaseImplO5WinTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: CheckGameOverUseCase

    @Before
    fun setUp() {
        useCase = CheckGameOverUseCaseImpl(defaultRepository)
    }

    @Test
    fun checkGameOver_checkOTableFiveColumnOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 4, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveColumnTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 4, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveColumnThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 2, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 4, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveColumnFour() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 3, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 4, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveColumnFive() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 4, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 4, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveRowOne() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 0, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveRowTwo() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 1, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveRowThree() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 2, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveRowFour() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 3, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveRowFive() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 4, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 4, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 4, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 4, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 4, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveOblique1() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 4, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveOblique2() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 4, row = 0, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 4, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveOblique3() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 0, row = 4, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 4, row = 0, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    @Test
    fun checkGameOver_checkOTableFiveOblique4() {
        val tictactoes = listOf(
            TicTacToeEntity(column = 4, row = 4, turnGame = "O"),
            TicTacToeEntity(column = 3, row = 3, turnGame = "O"),
            TicTacToeEntity(column = 2, row = 2, turnGame = "O"),
            TicTacToeEntity(column = 1, row = 1, turnGame = "O"),
            TicTacToeEntity(column = 0, row = 0, turnGame = "O"),
        )

        assertResult(tictactoes)
    }

    private fun assertResult(tictactoes: List<TicTacToeEntity>) {
        val result = useCase.checkGameOver(tictactoes, 5)

        val expected = CheckGameOver(winnerPlayer = "O", gameState = CheckGameOver.GameState.End)
        assertThat(result).isEqualTo(expected)
    }

}
