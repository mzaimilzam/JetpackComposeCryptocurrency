package com.mzaimilzam.jetpackcomposecryptocurrency.di

import com.mzaimilzam.jetpackcomposecryptocurrency.BuildConfig
import com.mzaimilzam.jetpackcomposecryptocurrency.common.Constant
import com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.CoinPaprikaApi
import com.mzaimilzam.jetpackcomposecryptocurrency.data.repository.CoinRepositoryImp
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        } else {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()

        }
    }

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(client: OkHttpClient): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(CoinPaprikaApi::class.java)

    }

    @Provides
    @Singleton
    fun provideCoinrepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImp(api)
    }
}