package com.adedom.tictactoe.domain.di

import com.adedom.tictactoe.domain.usecase.DeleteTicTacToeUseCase
import com.adedom.tictactoe.domain.usecase.DeleteTicTacToeUseCaseImpl
import com.adedom.tictactoe.domain.usecase.SaveTicTacToeUseCase
import com.adedom.tictactoe.domain.usecase.SaveTicTacToeUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    single<SaveTicTacToeUseCase> { SaveTicTacToeUseCaseImpl(get()) }
    single<DeleteTicTacToeUseCase> { DeleteTicTacToeUseCaseImpl(get()) }

}