package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import kotlinx.coroutines.flow.Flow

interface GetWinnerGamePlayerXUseCase {
    operator fun invoke(): Flow<Int>
    fun filterWinnerPlayerXInList(winnerGames: List<WinnerGameEntity>): Int
}
