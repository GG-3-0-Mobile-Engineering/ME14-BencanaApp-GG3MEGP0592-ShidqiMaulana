package com.example.finalprojectgigih.core.di

import androidx.room.Room
import com.example.finalprojectgigih.core.data.MainRepository
import com.example.finalprojectgigih.core.data.source.local.LocalDataSource
import com.example.finalprojectgigih.core.data.source.local.room.MainDatabase
import com.example.finalprojectgigih.core.data.source.remote.RemoteDataSource
import com.example.finalprojectgigih.core.data.source.remote.network.ApiService
import com.example.finalprojectgigih.core.domain.repository.IMainRepository
import com.example.finalprojectgigih.core.utility.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<MainDatabase>().mainDAO() }
    single {
        val cipher = "Lq8GGxvL9Bcn5Bex3qwccWaCgrUPzTxe30cRcL0NgG2MM8BGkfxl88yMyJZBgDH5WGvLx9Bcn5B"
        val passphrase: ByteArray = SQLiteDatabase.getBytes(cipher.toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(), MainDatabase::class.java, "Main.db"
        ).fallbackToDestructiveMigration().openHelperFactory(factory).build()
    }
}

val networkModule = module {
    single {
        val hostname = "data.petabencana.id"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/lOVlhY76AiBWuuGR6RNyjRHQBF7U80tiTqqz7Wbg58M=")
            .add(hostname, "sha256/DxH4tt40L+eduF6szpY6TONlxhZhBd+pJ9wbHlQ2fuw=")
            .add(hostname, "sha256/++MBgDH5WGvL9Bcn5Be30cRcL0f5O+NyoXuWtQdX1aI=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://data.petabencana.id/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMainRepository> {
        MainRepository(
            get(),
            get(),
            get()
        )
    }
}