package com.adedom.tictactoe.domain.di

import com.adedom.tictactoe.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {

    single<GetTicTacToeAllModeUseCase> { GetTicTacToeAllModeUseCaseImpl(get()) }
    single<SaveTicTacToeUseCase> { SaveTicTacToeUseCaseImpl(get()) }
    single<DeleteTicTacToeUseCase> { DeleteTicTacToeUseCaseImpl(get()) }
    single<GetTicTacToeUseCase> { GetTicTacToeUseCaseImpl(get()) }
    single<CheckGameOverUseCase> { CheckGameOverUseCaseImpl(get()) }
    single<SaveWinnerGameUseCase> { SaveWinnerGameUseCaseImpl(get()) }
    single<GetWinnerGamePlayerXUseCase> { GetWinnerGamePlayerXUseCaseImpl(get()) }
    single<GetWinnerGamePlayerOUseCase> { GetWinnerGamePlayerOUseCaseImpl(get()) }
    single<DeleteWinnerGameUseCase> { DeleteWinnerGameUseCaseImpl(get()) }
    single<DeleteTicTacToeLastUseCase> { DeleteTicTacToeLastUseCaseImpl(get()) }

}
