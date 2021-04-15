package com.adedom.tictactoe.presentation.di

import com.adedom.tictactoe.presentation.game.GameViewModel
import com.adedom.tictactoe.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel(get(), get()) }
    viewModel { GameViewModel(get(), get(), get(), get(), get(), get(), get(), get(), get()) }

}
