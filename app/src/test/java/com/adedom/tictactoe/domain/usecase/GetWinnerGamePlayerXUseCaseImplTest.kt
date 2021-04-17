package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import com.adedom.tictactoe.data.repositories.DefaultRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class GetWinnerGamePlayerXUseCaseImplTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: GetWinnerGamePlayerXUseCase

    @Before
    fun setUp() {
        useCase = GetWinnerGamePlayerXUseCaseImpl(defaultRepository)
    }

    @Test
    fun filterWinnerPlayerXInList_filterX_returnTwo() {
        val winnerGames = listOf(
            WinnerGameEntity("X", 123456),
            WinnerGameEntity("O", 234567),
            WinnerGameEntity("X", 345678),
        )

        val result = useCase.filterWinnerPlayerXInList(winnerGames)

        assertThat(result).isEqualTo(2)
    }

}
