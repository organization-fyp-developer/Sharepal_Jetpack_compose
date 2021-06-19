// Generated by Dagger (https://dagger.dev).
package com.hidevelopers.sharepal.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideMainDispatcherFactory implements Factory<CoroutineDispatcher> {
  @Override
  public CoroutineDispatcher get() {
    return provideMainDispatcher();
  }

  public static AppModule_ProvideMainDispatcherFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CoroutineDispatcher provideMainDispatcher() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMainDispatcher());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideMainDispatcherFactory INSTANCE = new AppModule_ProvideMainDispatcherFactory();
  }
}
