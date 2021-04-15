package com.adedom.tictactoe.presentation.main

import com.adedom.tictactoe.base.BaseViewModel
import com.adedom.tictactoe.domain.usecase.DeleteTicTacToeUseCase
import com.adedom.tictactoe.domain.usecase.DeleteWinnerGameUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val deleteTicTacToeUseCase: DeleteTicTacToeUseCase,
    private val deleteWinnerGameUseCase: DeleteWinnerGameUseCase,
) : BaseViewModel() {

    fun initialDatabase() {
        launch {
            deleteTicTacToeUseCase()
            deleteWinnerGameUseCase()
        }
    }

}
