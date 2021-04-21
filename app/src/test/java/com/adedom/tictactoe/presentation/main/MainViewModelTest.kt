package com.adedom.tictactoe.presentation.main

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adedom.tictactoe.data.model.GameMode
import com.adedom.tictactoe.domain.usecase.DeleteTicTacToeUseCase
import com.adedom.tictactoe.domain.usecase.DeleteWinnerGameUseCase
import com.adedom.tictactoe.domain.usecase.GetTicTacToeAllModeUseCase
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.KoinContextHandler
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val getTicTacToeAllModeUseCase = mockk<GetTicTacToeAllModeUseCase>(relaxed = true)
    private val deleteTicTacToeUseCase = mockk<DeleteTicTacToeUseCase>(relaxed = true)
    private val deleteWinnerGameUseCase = mockk<DeleteWinnerGameUseCase>(relaxed = true)
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel(
            getTicTacToeAllModeUseCase,
            deleteTicTacToeUseCase,
            deleteWinnerGameUseCase
        )
    }

    @After
    fun cleanup() {
        KoinContextHandler.stop()
    }

    @Test
    fun testTest() {
        val result = "test"

        assertThat(result).isEqualTo("test")
    }

    @Test
    fun getTicTacToeAllMode_returnThreeMode345() {
        val list = listOf(
            GameMode(1, "3 x 3", 3),
            GameMode(2, "4 x 4", 4),
            GameMode(3, "5 x 5", 5),
        )
        every { getTicTacToeAllModeUseCase() } returns list

        val result = viewModel.getTicTacToeAllMode

        assertThat(result).isEqualTo(list)
    }

}
