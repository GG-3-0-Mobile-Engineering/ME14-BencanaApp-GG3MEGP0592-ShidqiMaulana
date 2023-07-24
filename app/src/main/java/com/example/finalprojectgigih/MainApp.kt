package com.example.finalprojectgigih

import android.app.Application
import com.example.finalprojectgigih.core.di.databaseModule
import com.example.finalprojectgigih.core.di.networkModule
import com.example.finalprojectgigih.core.di.repositoryModule
import com.example.finalprojectgigih.di.useCaseModule
import com.example.finalprojectgigih.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MainApp)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}