package com.adedom.tictactoe.domain.usecase

interface SaveTicTacToeUseCase {
    suspend operator fun invoke(column: Int, row: Int)
    fun turnGameNow(turnGameLast: String): String
}
