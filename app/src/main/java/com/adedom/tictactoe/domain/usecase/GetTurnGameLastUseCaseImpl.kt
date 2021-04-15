package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.repositories.DefaultRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTurnGameLastUseCaseImpl(
    private val repository: DefaultRepository,
) : GetTurnGameLastUseCase {
    override fun invoke(): Flow<String?> {
        return repository.getTurnGameLastFlow().map {
            it?.let { if (it == "X") "O" else "X" }
        }
    }
}
