package com.adedom.tictactoe

import android.app.Application
import com.adedom.tictactoe.data.di.dataModule
import com.adedom.tictactoe.domain.di.domainModule
import com.adedom.tictactoe.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            koin.loadModules(
                listOf(
                    presentationModule,
                    domainModule,
                    dataModule,
                )
            )
            koin.createRootScope()
        }
    }
}
