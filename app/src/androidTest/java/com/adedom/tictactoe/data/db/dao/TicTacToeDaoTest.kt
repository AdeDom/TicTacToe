package com.adedom.tictactoe.data.db.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adedom.tictactoe.data.db.AppDatabase
import com.adedom.tictactoe.data.db.entities.TicTacToeEntity
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TicTacToeDaoTest : TestCase() {

    private lateinit var db: AppDatabase
    private lateinit var dao: TicTacToeDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.getTicTacToeDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadDatabase() = runBlocking {
        val ticTacToeEntity1 = TicTacToeEntity(1, 1, "X", 123456)
        val ticTacToeEntity2 = TicTacToeEntity(2, 2, "O", 234567)

        dao.saveTicTacToe(ticTacToeEntity1)
        dao.saveTicTacToe(ticTacToeEntity2)
        val result = dao.getTicTacToeList()

        assertThat(result).isEqualTo(listOf(ticTacToeEntity1, ticTacToeEntity2))
    }

    @Test
    fun getTurnGameLast_firstGetTurnGameLast_returnNull() = runBlocking {
        val result = dao.getTurnGameLast()

        assertThat(result).isNull()
    }

    @Test
    fun getTurnGameLast_addTwoEntity_returnTurnO() = runBlocking {
        val ticTacToeEntity1 = TicTacToeEntity(1, 1, "X", 123456)
        val ticTacToeEntity2 = TicTacToeEntity(2, 2, "O", 234567)
        dao.saveTicTacToe(ticTacToeEntity1)
        dao.saveTicTacToe(ticTacToeEntity2)

        val result = dao.getTurnGameLast()

        assertThat(result).isEqualTo("O")
    }

    @Test
    fun deleteTicTacToeLast_addThreeEntity_returnTwoEntity() = runBlocking {
        val ticTacToeEntity1 = TicTacToeEntity(1, 1, "X", 123456)
        val ticTacToeEntity2 = TicTacToeEntity(2, 2, "O", 234567)
        val ticTacToeEntity3 = TicTacToeEntity(0, 0, "X", 345678)
        dao.saveTicTacToe(ticTacToeEntity1)
        dao.saveTicTacToe(ticTacToeEntity2)
        dao.saveTicTacToe(ticTacToeEntity3)

        dao.deleteTicTacToeLast()
        val result = dao.getTicTacToeList()

        assertThat(result).isEqualTo(listOf(ticTacToeEntity1, ticTacToeEntity2))
    }

    @Test
    fun deleteTicTacToe_addEntity_returnIsEmpty()= runBlocking {
        val ticTacToeEntity1 = TicTacToeEntity(1, 1, "X", 123456)
        val ticTacToeEntity2 = TicTacToeEntity(2, 2, "O", 234567)
        dao.saveTicTacToe(ticTacToeEntity1)
        dao.saveTicTacToe(ticTacToeEntity2)

        dao.deleteTicTacToe()
        val result = dao.getTicTacToeList()

        assertThat(result).isEmpty()
    }

}
