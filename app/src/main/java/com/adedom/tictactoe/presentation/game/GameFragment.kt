package com.adedom.tictactoe.presentation.game

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.fragment.navArgs
import com.adedom.tictactoe.R
import com.adedom.tictactoe.base.BaseFragment
import com.adedom.tictactoe.domain.model.CheckGameOver
import kotlinx.android.synthetic.main.fragment_game.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : BaseFragment(R.layout.fragment_game) {

    private val args by navArgs<GameFragmentArgs>()
    private val viewModel by viewModel<GameViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        observeViewModel()
    }

    private fun setupView() {
        tvGameMode.text = args.gameMode.modeName
        compose_view.setContent {
            BoardGame(args.gameMode.size, viewModel)
        }
        btRestartGame.setOnClickListener {
            viewModel.deleteTicTacToe()
        }
    }

    private fun observeViewModel() {
        viewModel.checkGameOver(args.gameMode.size).observe { checkGameOver ->
            when (checkGameOver.gameOver) {
                is CheckGameOver.GameState.Initial -> {
                    tvGameMessage.text = if (checkGameOver.turnGame == null) {
                        getString(R.string.turn_game_initial)
                    } else {
                        getString(R.string.turn_game, checkGameOver.turnGame)
                    }
                }
                is CheckGameOver.GameState.End -> {
                    tvGameMessage.text = getString(R.string.game_over)
                }
                is CheckGameOver.GameState.Draw -> {
                    tvGameMessage.text = getString(R.string.game_over)
                }
            }
        }
    }

}

@Composable
fun BoardGame(size: Int, viewModel: GameViewModel) {
    val resources = LocalContext.current.resources
    val displayMetrics = resources.displayMetrics
    val srcWidth = ((displayMetrics.widthPixels / displayMetrics.density) - 32) / size

    val ticTacToe by viewModel.getTicTacToe.observeAsState(emptyList())
    val checkGameOver by viewModel.checkGameOver(size).observeAsState()

    when (checkGameOver?.gameOver) {
        is CheckGameOver.GameState.Initial -> {
            Column {
                Array(size) { IntArray(size) }.forEachIndexed { i, ints ->
                    Row {
                        ints.forEachIndexed { j, _ ->
                            val entity = ticTacToe.filter { it.column == i }
                                .singleOrNull { it.row == j }

                            Button(
                                onClick = {
                                    viewModel.saveTicTacToe(i, j)
                                },
                                modifier = Modifier
                                    .width(srcWidth.dp)
                                    .height(srcWidth.dp),
                                enabled = entity == null
                            ) {
                                entity?.let { Text(it.turnGame, color = Color.Black) }
                            }
                        }
                    }
                }
            }
        }
        is CheckGameOver.GameState.End -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff14bdac)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "${checkGameOver?.winnerPlayer}",
                    color = Color(0xff545454),
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 32.sp,
                )
                Text(
                    resources.getString(R.string.winner),
                    color = Color(0xff545454),
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 32.sp
                )
            }
        }
        is CheckGameOver.GameState.Draw -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff14bdac)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Text(
                        "X",
                        color = Color(0xff545454),
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        fontSize = 32.sp,
                    )
                    Text(
                        "O",
                        color = Color(0xfff2ebd3),
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        fontSize = 32.sp,
                    )
                }
                Text(
                    resources.getString(R.string.draw),
                    color = Color(0xff545454),
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    fontSize = 32.sp
                )
            }
        }
    }

}
