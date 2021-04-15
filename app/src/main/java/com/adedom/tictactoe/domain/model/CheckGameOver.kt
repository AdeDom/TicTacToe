package com.adedom.tictactoe.domain.model

data class CheckGameOver(
    val winnerPlayer: String,
    val isGameOver: Boolean,
    val turnGame: String? = null,
)
