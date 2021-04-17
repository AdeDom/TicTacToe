package com.adedom.tictactoe.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tic_tac_toe")
data class TicTacToeEntity(
    val column: Int,
    val row: Int,
    val turnGame: String,
    val timeMillis: Long = 0,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
