package com.adedom.tictactoe.data.di

import com.adedom.tictactoe.data.db.AppDatabase
import com.adedom.tictactoe.data.repositories.DefaultRepository
import com.adedom.tictactoe.data.repositories.DefaultRepositoryImpl
import com.adedom.tictactoe.data.source.DefaultDataSource
import com.adedom.tictactoe.data.source.DefaultDataSourceImpl
import org.koin.dsl.module

val dataModule = module {

    single { AppDatabase(get()) }

    single<DefaultDataSource> { DefaultDataSourceImpl(get()) }

    single<DefaultRepository> { DefaultRepositoryImpl(get()) }

}
