package com.adedom.tictactoe.presentation.game

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adedom.tictactoe.domain.usecase.*
import com.google.common.truth.Truth.assertThat
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
class GameViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val saveTicTacToeUseCase = mockk<SaveTicTacToeUseCase>(relaxed = true)
    private val getTicTacToeUseCase = mockk<GetTicTacToeUseCase>(relaxed = true)
    private val deleteTicTacToeUseCase = mockk<DeleteTicTacToeUseCase>(relaxed = true)
    private val checkGameOverUseCase = mockk<CheckGameOverUseCase>(relaxed = true)
    private val saveWinnerGameUseCase = mockk<SaveWinnerGameUseCase>(relaxed = true)
    private val getWinnerGamePlayerXUseCase = mockk<GetWinnerGamePlayerXUseCase>(relaxed = true)
    private val getWinnerGamePlayerOUseCase = mockk<GetWinnerGamePlayerOUseCase>(relaxed = true)
    private val deleteWinnerGameUseCase = mockk<DeleteWinnerGameUseCase>(relaxed = true)
    private val deleteTicTacToeLastUseCase = mockk<DeleteTicTacToeLastUseCase>(relaxed = true)
    private lateinit var viewModel: GameViewModel

    @Before
    fun setUp() {
        viewModel = GameViewModel(
            saveTicTacToeUseCase,
            getTicTacToeUseCase,
            deleteTicTacToeUseCase,
            checkGameOverUseCase,
            saveWinnerGameUseCase,
            getWinnerGamePlayerXUseCase,
            getWinnerGamePlayerOUseCase,
            deleteWinnerGameUseCase,
            deleteTicTacToeLastUseCase,
        )
    }

    @After
    fun cleanup() {
        KoinContextHandler.stop()
    }

    @Test
    fun test() {
        val result = "test"

        assertThat(result).isEqualTo("test")
    }

}
