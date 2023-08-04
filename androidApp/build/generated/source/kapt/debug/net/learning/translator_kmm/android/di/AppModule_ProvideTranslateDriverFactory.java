package net.learning.translator_kmm.android.di;

import android.app.Application;
import com.squareup.sqldelight.db.SqlDriver;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideTranslateDriverFactory implements Factory<SqlDriver> {
  private final Provider<Application> appProvider;

  public AppModule_ProvideTranslateDriverFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public SqlDriver get() {
    return provideTranslateDriver(appProvider.get());
  }

  public static AppModule_ProvideTranslateDriverFactory create(Provider<Application> appProvider) {
    return new AppModule_ProvideTranslateDriverFactory(appProvider);
  }

  public static SqlDriver provideTranslateDriver(Application app) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTranslateDriver(app));
  }
}
