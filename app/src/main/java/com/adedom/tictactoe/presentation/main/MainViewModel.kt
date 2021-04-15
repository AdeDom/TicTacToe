package com.adedom.tictactoe.presentation.main

import com.adedom.tictactoe.base.BaseViewModel
import com.adedom.tictactoe.domain.usecase.DeleteTicTacToeUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val deleteTicTacToeUseCase: DeleteTicTacToeUseCase,
) : BaseViewModel() {

    fun deleteTicTacToe() {
        launch {
            deleteTicTacToeUseCase()
        }
    }

}
