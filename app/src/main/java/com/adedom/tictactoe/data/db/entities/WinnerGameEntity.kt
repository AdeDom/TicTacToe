package com.adedom.tictactoe.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "winner_game")
data class WinnerGameEntity(
    val winnerPlayer: String,
    val timeMillis: Long,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
