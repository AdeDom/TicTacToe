package com.adedom.tictactoe.presentation.game

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.navArgs
import com.adedom.tictactoe.R
import com.adedom.tictactoe.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_game.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : BaseFragment(R.layout.fragment_game) {

    private val args by navArgs<GameFragmentArgs>()
    private val viewModel by viewModel<GameViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        tvGameMode.text = args.gameMode.modeName
        tvTurnGame.text = getString(R.string.turn_game_initial)
        compose_view.setContent {
            BoardGame(args.gameMode.size, viewModel)
        }
    }

}

@Composable
fun BoardGame(size: Int, viewModel: GameViewModel) {
    val displayMetrics = LocalContext.current.resources.displayMetrics
    val srcWidth = ((displayMetrics.widthPixels / displayMetrics.density) - 32) / size

    Column {
        Array(size) { IntArray(size) }.forEachIndexed { i, ints ->
            Row {
                ints.forEachIndexed { j, _ ->
                    Button(
                        onClick = {
                            viewModel.saveTicTacToe(i, j)
                        },
                        modifier = Modifier
                            .width(srcWidth.dp)
                            .height(srcWidth.dp)
                    ) {
                    }
                }
            }
        }
    }
}
