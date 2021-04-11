package com.adedom.tictactoe.presentation.game

import android.os.Bundle
import android.view.View
import androidx.compose.material.Text
import androidx.navigation.fragment.navArgs
import com.adedom.tictactoe.R
import com.adedom.tictactoe.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : BaseFragment(R.layout.fragment_game) {

    private val args by navArgs<GameFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        tvGameMode.text = args.gameMode.modeName
        tvTurnGame.text = getString(R.string.turn_game_initial)
        compose_view.setContent {
            Text("Hello Compose!")
        }
    }

}
