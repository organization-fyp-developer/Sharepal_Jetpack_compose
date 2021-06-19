// Generated by Dagger (https://dagger.dev).
package com.hidevelopers.sharepal.repository;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class StorageRepo_Factory implements Factory<StorageRepo> {
  private final Provider<Context> contextProvider;

  public StorageRepo_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public StorageRepo get() {
    return newInstance(contextProvider.get());
  }

  public static StorageRepo_Factory create(Provider<Context> contextProvider) {
    return new StorageRepo_Factory(contextProvider);
  }

  public static StorageRepo newInstance(Context context) {
    return new StorageRepo(context);
  }
}
