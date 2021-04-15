package com.adedom.tictactoe.presentation.di

import com.adedom.tictactoe.presentation.game.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { GameViewModel(get(), get(), get(), get()) }

}
