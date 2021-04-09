package com.adedom.tictactoe.presentation.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tictactoe.R
import com.adedom.tictactoe.base.BaseFragment
import com.adedom.tictactoe.presentation.model.GameMode
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val mAdapter by lazy { MainAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        viewEvent()
    }

    private fun setupView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        mAdapter.submitList(getAllMode())
    }

    private fun viewEvent() {
        mAdapter.setOnClickListener {
            val navDirections = MainFragmentDirections.actionMainFragmentToGameFragment(it)
            findNavController().navigate(navDirections)
        }
    }

    private fun getAllMode(): List<GameMode> {
        return listOf(
            GameMode(1, "3 x 3"),
            GameMode(2, "4 x 4"),
            GameMode(3, "5 x 5"),
            GameMode(4, "6 x 6"),
            GameMode(5, "7 x 7"),
            GameMode(6, "8 x 8"),
            GameMode(7, "9 x 9"),
        )
    }

}
