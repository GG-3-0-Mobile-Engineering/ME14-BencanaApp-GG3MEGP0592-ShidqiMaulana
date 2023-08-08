package com.gigih.awarealert

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.gigih.awarealert.core.di.databaseModule
import com.gigih.awarealert.core.di.networkModule
import com.gigih.awarealert.core.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MainApp)
            modules(
                listOf(
                    databaseModule, networkModule, repositoryModule,
                    com.gigih.awarealert.di.useCaseModule,
                    com.gigih.awarealert.di.viewModelModule
                )
            )
        }
        val sharedPreferences = getSharedPreferences("SharedPrefs", MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("DarkModeState", false)
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}