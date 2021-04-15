package com.adedom.tictactoe.presentation.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.tictactoe.R
import com.adedom.tictactoe.base.BaseFragment
import com.adedom.tictactoe.presentation.model.GameMode
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val viewModel by viewModel<MainViewModel>()
    private val mHeaderAdapter by lazy { HeaderAdapter() }
    private val mAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.deleteTicTacToe()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        viewEvent()
    }

    private fun setupView() {
        val adt = ConcatAdapter(
            mHeaderAdapter,
            mAdapter,
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt
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
            GameMode(1, "3 x 3", 3),
            GameMode(2, "4 x 4", 4),
            GameMode(3, "5 x 5", 5),
        )
    }

}
