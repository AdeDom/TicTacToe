package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import kotlinx.coroutines.flow.Flow

interface GetWinnerGamePlayerOUseCase {
    operator fun invoke(): Flow<Int>
    fun filterWinnerPlayerOInList(winnerGames: List<WinnerGameEntity>): Int
}
