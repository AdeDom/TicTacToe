package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.repositories.DefaultRepository

class DeleteTicTacToeLastUseCaseImpl(
    private val repository: DefaultRepository,
) : DeleteTicTacToeLastUseCase {
    override suspend fun invoke() {
        return repository.deleteTicTacToeLast()
    }
}
