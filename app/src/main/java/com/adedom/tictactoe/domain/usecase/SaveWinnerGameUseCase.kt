package com.adedom.tictactoe.domain.usecase

interface SaveWinnerGameUseCase {
    suspend operator fun invoke(winnerPlayer: String)
}
