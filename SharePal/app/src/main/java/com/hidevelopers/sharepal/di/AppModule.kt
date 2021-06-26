package com.hidevelopers.sharepal.di

import android.content.Context
import com.hidevelopers.sharepal.repository.ExternalStorageRepository
import com.hidevelopers.sharepal.repository.StorageRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ) = context

//    @Singleton
//    @Provides
//    fun provideMainDispatcher() = Dispatchers.Main as CoroutineDispatcher

//    @Singleton
//    @Provides
//    fun provideRepository(
//        @ApplicationContext context: Context
//    ) = StorageRepo(context) as ExternalStorageRepository
}