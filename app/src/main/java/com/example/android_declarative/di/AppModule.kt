package com.example.android_declarative.di

import android.app.Application
import com.example.android_declarative.db.AppDatabase
import com.example.android_declarative.db.TVShowDao
import com.example.android_declarative.network.Server.IS_TESTER
import com.example.android_declarative.network.Server.SERVER_DEVELOPMENT
import com.example.android_declarative.network.Server.SERVER_PRODUCTION
import com.example.android_declarative.network.TVShowService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun server(): String{
        return if (IS_TESTER) SERVER_DEVELOPMENT else SERVER_PRODUCTION
    }

    @Provides
    @Singleton
    fun retrofitClient(): Retrofit{
        return Retrofit.Builder().baseUrl(server())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun tvShowService(): TVShowService{
        return retrofitClient().create(TVShowService::class.java)
    }

    @Provides
    @Singleton
    fun appDatabase(context: Application): AppDatabase {
        return AppDatabase.getAppDBInstance(context)
    }

    @Provides
    @Singleton
    fun tvShowDao(appDatabase: AppDatabase): TVShowDao {
        return appDatabase.getTVShowDao()
    }

}