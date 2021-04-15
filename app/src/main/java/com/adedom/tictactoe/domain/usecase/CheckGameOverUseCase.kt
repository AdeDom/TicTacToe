package com.adedom.tictactoe.domain.usecase

import com.adedom.tictactoe.domain.model.CheckGameOver
import kotlinx.coroutines.flow.Flow

interface CheckGameOverUseCase {
    operator fun invoke(size: Int): Flow<CheckGameOver>
}
