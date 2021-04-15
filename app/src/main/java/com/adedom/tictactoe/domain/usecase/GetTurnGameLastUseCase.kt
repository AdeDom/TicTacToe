package com.adedom.tictactoe.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetTurnGameLastUseCase {
    operator fun invoke():Flow<String?>
}
