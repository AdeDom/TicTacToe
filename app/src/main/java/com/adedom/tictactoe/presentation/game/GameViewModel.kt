package com.adedom.tictactoe.presentation.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.adedom.tictactoe.base.BaseViewModel
import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.domain.model.CheckGameOver
import com.adedom.tictactoe.domain.usecase.*
import kotlinx.coroutines.launch

class GameViewModel(
    private val saveTicTacToeUseCase: SaveTicTacToeUseCase,
    private val getTicTacToeUseCase: GetTicTacToeUseCase,
    private val deleteTicTacToeUseCase: DeleteTicTacToeUseCase,
    private val checkGameOverUseCase: CheckGameOverUseCase,
) : BaseViewModel() {

    val getTicTacToe: LiveData<List<TicTacToeEntity>> = getTicTacToeUseCase().asLiveData()

    init {
        deleteTicTacToe()
    }

    fun saveTicTacToe(column: Int, row: Int) {
        launch {
            saveTicTacToeUseCase(column, row)
        }
    }

    fun deleteTicTacToe() {
        launch {
            deleteTicTacToeUseCase()
        }
    }

    fun checkGameOver(size: Int): LiveData<CheckGameOver> {
        return checkGameOverUseCase(size).asLiveData()
    }

}
