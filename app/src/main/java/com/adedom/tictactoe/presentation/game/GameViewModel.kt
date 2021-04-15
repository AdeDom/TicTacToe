package com.adedom.tictactoe.presentation.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.adedom.tictactoe.base.BaseViewModel
import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.domain.usecase.DeleteTicTacToeUseCase
import com.adedom.tictactoe.domain.usecase.GetTicTacToeUseCase
import com.adedom.tictactoe.domain.usecase.GetTurnGameLastUseCase
import com.adedom.tictactoe.domain.usecase.SaveTicTacToeUseCase
import kotlinx.coroutines.launch

class GameViewModel(
    private val saveTicTacToeUseCase: SaveTicTacToeUseCase,
    private val getTurnGameLastUseCase: GetTurnGameLastUseCase,
    private val getTicTacToeUseCase: GetTicTacToeUseCase,
    private val deleteTicTacToeUseCase: DeleteTicTacToeUseCase,
) : BaseViewModel() {

    val getTurnGameLast: LiveData<String?> = getTurnGameLastUseCase().asLiveData()
    val getTicTacToe: LiveData<List<TicTacToeEntity>> = getTicTacToeUseCase().asLiveData()

    init {
        deleteTicTacToe()
    }

    fun saveTicTacToe(column: Int, row: Int) {
        launch {
            saveTicTacToeUseCase(column, row)
        }
    }

    fun deleteTicTacToe(){
        launch {
            deleteTicTacToeUseCase()
        }
    }

}
