package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.model.GameMode
import com.adedom.tictactoe.data.repositories.DefaultRepository

class GetTicTacToeAllModeUseCaseImpl(
    private val repository: DefaultRepository,
) : GetTicTacToeAllModeUseCase {
    override fun invoke(): List<GameMode> {
        return repository.getTicTacToeAllMode()
    }
}
