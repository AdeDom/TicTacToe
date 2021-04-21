package com.adedom.tictactoe.presentation.main

import com.adedom.tictactoe.base.BaseViewModel
import com.adedom.tictactoe.data.model.GameMode
import com.adedom.tictactoe.domain.usecase.DeleteTicTacToeUseCase
import com.adedom.tictactoe.domain.usecase.DeleteWinnerGameUseCase
import com.adedom.tictactoe.domain.usecase.GetTicTacToeAllModeUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getTicTacToeAllModeUseCase: GetTicTacToeAllModeUseCase,
    private val deleteTicTacToeUseCase: DeleteTicTacToeUseCase,
    private val deleteWinnerGameUseCase: DeleteWinnerGameUseCase,
) : BaseViewModel() {

    val getTicTacToeAllMode: List<GameMode>
        get() = getTicTacToeAllModeUseCase.invoke()

    fun initialDatabase() {
        launch {
            deleteTicTacToeUseCase()
            deleteWinnerGameUseCase()
        }
    }

}
