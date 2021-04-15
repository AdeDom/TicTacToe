package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.repositories.DefaultRepository

class DeleteTicTacToeUseCaseImpl(
    private val repository: DefaultRepository,
) : DeleteTicTacToeUseCase {
    override suspend fun invoke() {
        return repository.deleteTicTacToe()
    }
}
