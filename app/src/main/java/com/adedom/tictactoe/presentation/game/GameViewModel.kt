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
    private val saveWinnerGameUseCase: SaveWinnerGameUseCase,
    private val getWinnerGamePlayerXUseCase: GetWinnerGamePlayerXUseCase,
    private val getWinnerGamePlayerOUseCase: GetWinnerGamePlayerOUseCase,
    private val deleteWinnerGameUseCase: DeleteWinnerGameUseCase,
    private val deleteTicTacToeLastUseCase: DeleteTicTacToeLastUseCase,
) : BaseViewModel() {

    val getTicTacToe: LiveData<List<TicTacToeEntity>> = getTicTacToeUseCase().asLiveData()
    val getWinnerGamePlayerX: LiveData<Int> = getWinnerGamePlayerXUseCase().asLiveData()
    val getWinnerGamePlayerO: LiveData<Int> = getWinnerGamePlayerOUseCase().asLiveData()

    init {
        launch {
            deleteTicTacToeUseCase()
            deleteWinnerGameUseCase()
        }
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

    fun saveWinnerGame(winnerPlayer: String) {
        launch {
            saveWinnerGameUseCase(winnerPlayer)
        }
    }

    fun deleteTicTacToeLast(){
        launch {
            deleteTicTacToeLastUseCase()
        }
    }

}
