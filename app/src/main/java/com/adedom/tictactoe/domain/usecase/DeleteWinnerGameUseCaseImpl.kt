package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.repositories.DefaultRepository

class DeleteWinnerGameUseCaseImpl(
    private val repository: DefaultRepository,
) : DeleteWinnerGameUseCase {
    override suspend fun invoke() {
        return repository.deleteWinnerGame()
    }
}
