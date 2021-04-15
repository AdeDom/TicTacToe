package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.repositories.DefaultRepository
import kotlinx.coroutines.flow.Flow

class GetTicTacToeUseCaseImpl(
    private val repository: DefaultRepository,
) : GetTicTacToeUseCase {
    override fun invoke(): Flow<List<TicTacToeEntity>> {
        return repository.getTicTacToeFlow()
    }
}
