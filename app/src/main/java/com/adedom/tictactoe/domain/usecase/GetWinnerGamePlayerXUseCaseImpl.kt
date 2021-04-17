package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import com.adedom.tictactoe.data.repositories.DefaultRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetWinnerGamePlayerXUseCaseImpl(
    private val repository: DefaultRepository,
) : GetWinnerGamePlayerXUseCase {

    override fun invoke(): Flow<Int> {
        return repository.getWinnerGameFlow().map { filterWinnerPlayerXInList(it) }
    }

    override fun filterWinnerPlayerXInList(winnerGames: List<WinnerGameEntity>): Int {
        return winnerGames.filter { it.winnerPlayer == "X" }.size
    }

}
