package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.domain.model.CheckGameOver
import kotlinx.coroutines.flow.Flow

interface CheckGameOverUseCase {
    operator fun invoke(size: Int): Flow<CheckGameOver>
    fun checkGameOver(tictactoes: List<TicTacToeEntity>, size: Int): CheckGameOver
}
