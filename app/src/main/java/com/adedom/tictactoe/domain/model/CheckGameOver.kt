package com.adedom.tictactoe.domain.model

data class CheckGameOver(
    val winnerPlayer: String = "",
    val gameState: GameState = GameState.Initial,
    val turnGame: String? = null,
) {
    sealed class GameState {
        object Initial : GameState()
        object End : GameState()
        object Draw : GameState()
    }
}
