package com.adedom.tictactoe.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetWinnerGamePlayerOUseCase {
    operator fun invoke(): Flow<Int>
}
