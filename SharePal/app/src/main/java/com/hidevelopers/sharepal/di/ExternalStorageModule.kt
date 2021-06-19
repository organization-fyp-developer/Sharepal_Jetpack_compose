package com.hidevelopers.sharepal.di

import android.content.Context
import com.hidevelopers.sharepal.repository.ExternalStorageRepository
import com.hidevelopers.sharepal.repository.StorageRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped


@Module
@InstallIn(ActivityComponent::class)
object ExternalStorageModule {

    @ActivityScoped
    @Provides
    fun provideExternalStorageRepository() = StorageRepo() as ExternalStorageRepository
}