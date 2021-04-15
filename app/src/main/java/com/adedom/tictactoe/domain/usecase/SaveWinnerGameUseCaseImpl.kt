package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import com.adedom.tictactoe.data.repositories.DefaultRepository

class SaveWinnerGameUseCaseImpl(
    private val repository: DefaultRepository,
) : SaveWinnerGameUseCase {
    override suspend fun invoke(winnerPlayer: String) {
        val winnerGameEntity = WinnerGameEntity(
            winnerPlayer = winnerPlayer,
            timeMillis = System.currentTimeMillis(),
        )
        return repository.saveWinnerGame(winnerGameEntity)
    }
}
