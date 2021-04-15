package com.adedom.tictactoe.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adedom.tictactoe.data.db.dao.TicTacToeDao
import com.adedom.tictactoe.data.db.dao.WinnerGameDao
import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.adedom.tictactoe.data.db.entities.WinnerGameEntity

@Database(
    entities = [TicTacToeEntity::class, WinnerGameEntity::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTicTacToeDao(): TicTacToeDao

    abstract fun getWinnerGameDao(): WinnerGameDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "tictactoe.db"
        ).fallbackToDestructiveMigration().build()
    }

}
