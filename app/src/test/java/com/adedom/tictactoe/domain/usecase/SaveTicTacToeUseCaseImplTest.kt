package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.repositories.DefaultRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class SaveTicTacToeUseCaseImplTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: SaveTicTacToeUseCase

    @Before
    fun setUp() {
        useCase = SaveTicTacToeUseCaseImpl(defaultRepository)
    }

    @Test
    fun turnGameNow_turnX_returnO() {
        val turnGameLast = "X"

        val result = useCase.turnGameNow(turnGameLast)

        assertThat(result).isEqualTo("O")
    }

}
