package com.adedom.tictactoe.domain.di

import com.adedom.tictactoe.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {

    single<SaveTicTacToeUseCase> { SaveTicTacToeUseCaseImpl(get()) }
    single<DeleteTicTacToeUseCase> { DeleteTicTacToeUseCaseImpl(get()) }
    single<GetTicTacToeUseCase> { GetTicTacToeUseCaseImpl(get()) }
    single<CheckGameOverUseCase> { CheckGameOverUseCaseImpl(get()) }

}
