package com.adedom.tictactoe.data.db.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adedom.tictactoe.data.db.AppDatabase
import com.adedom.tictactoe.data.db.entities.WinnerGameEntity
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WinnerGameDaoTest : TestCase() {

    private lateinit var db: AppDatabase
    private lateinit var dao: WinnerGameDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.getWinnerGameDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadDatabase() = runBlocking {
        val winnerGameEntity1 = WinnerGameEntity("X", 123456)
        val winnerGameEntity2 = WinnerGameEntity("O", 234567)

        dao.saveWinnerGame(winnerGameEntity1)
        dao.saveWinnerGame(winnerGameEntity2)
        val result = dao.getWinnerGameList()

        assertThat(result).isEqualTo(listOf(winnerGameEntity1, winnerGameEntity2))
    }

    @Test
    fun deleteWinnerGame_addTwoEntity_returnEmptyList()= runBlocking {
        val winnerGameEntity1 = WinnerGameEntity("X", 123456)
        val winnerGameEntity2 = WinnerGameEntity("O", 234567)
        dao.saveWinnerGame(winnerGameEntity1)
        dao.saveWinnerGame(winnerGameEntity2)

        dao.deleteWinnerGame()
        val result = dao.getWinnerGameList()

        assertThat(result).isEmpty()
    }

}
