package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.repositories.DefaultRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetWinnerGamePlayerOUseCaseImpl(
    private val repository: DefaultRepository,
) : GetWinnerGamePlayerOUseCase {
    override fun invoke(): Flow<Int> {
        return repository.getWinnerGameFlow().map { winnerGames ->
            winnerGames.filter { it.winnerPlayer == "O" }.size
        }
    }
}
