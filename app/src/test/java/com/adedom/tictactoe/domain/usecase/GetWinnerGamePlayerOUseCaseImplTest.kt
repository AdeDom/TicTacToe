package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import com.adedom.tictactoe.data.repositories.DefaultRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class GetWinnerGamePlayerOUseCaseImplTest {

    private val defaultRepository = mockk<DefaultRepository>(relaxed = true)
    private lateinit var useCase: GetWinnerGamePlayerOUseCase

    @Before
    fun setUp() {
        useCase = GetWinnerGamePlayerOUseCaseImpl(defaultRepository)
    }

    @Test
    fun filterWinnerPlayerOInList_filterO_returnOne() {
        val winnerGames = listOf(
            WinnerGameEntity("X", 123456),
            WinnerGameEntity("O", 234567),
            WinnerGameEntity("X", 345678),
        )

        val result = useCase.filterWinnerPlayerOInList(winnerGames)

        assertThat(result).isEqualTo(1)
    }

}
