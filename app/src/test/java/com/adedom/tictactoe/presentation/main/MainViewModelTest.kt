package com.adedom.tictactoe.presentation.main

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adedom.tictactoe.domain.usecase.DeleteTicTacToeUseCase
import com.adedom.tictactoe.domain.usecase.DeleteWinnerGameUseCase
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.KoinContextHandler
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class MainViewModelTest {

    private val deleteTicTacToeUseCase = mockk<DeleteTicTacToeUseCase>(relaxed = true)
    private val deleteWinnerGameUseCase = mockk<DeleteWinnerGameUseCase>(relaxed = true)
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel(deleteTicTacToeUseCase, deleteWinnerGameUseCase)
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

}
