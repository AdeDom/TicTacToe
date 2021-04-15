package com.adedom.tictactoe.presentation.game

import com.adedom.tictactoe.base.BaseViewModel
import com.adedom.tictactoe.domain.usecase.DeleteTicTacToeUseCase
import com.adedom.tictactoe.domain.usecase.SaveTicTacToeUseCase
import kotlinx.coroutines.launch

class GameViewModel(
    private val saveTicTacToeUseCase: SaveTicTacToeUseCase,
    private val deleteTicTacToeUseCase: DeleteTicTacToeUseCase,
) : BaseViewModel() {

    init {
        launch {
            deleteTicTacToeUseCase()
        }
    }

    fun saveTicTacToe(column: Int, row: Int) {
        launch {
            saveTicTacToeUseCase(column, row)
        }
    }

}
