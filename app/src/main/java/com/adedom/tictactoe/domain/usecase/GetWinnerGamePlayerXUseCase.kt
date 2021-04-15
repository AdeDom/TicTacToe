package com.adedom.tictactoe.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetWinnerGamePlayerXUseCase {
    operator fun invoke(): Flow<Int>
}
