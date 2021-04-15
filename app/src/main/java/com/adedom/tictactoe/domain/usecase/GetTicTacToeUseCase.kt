package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import kotlinx.coroutines.flow.Flow

interface GetTicTacToeUseCase {
    operator fun invoke(): Flow<List<TicTacToeEntity>>
}
