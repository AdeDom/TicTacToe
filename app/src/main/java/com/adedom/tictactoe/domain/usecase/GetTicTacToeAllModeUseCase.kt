package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.data.model.GameMode

interface GetTicTacToeAllModeUseCase {
    operator fun invoke():List<GameMode>
}
