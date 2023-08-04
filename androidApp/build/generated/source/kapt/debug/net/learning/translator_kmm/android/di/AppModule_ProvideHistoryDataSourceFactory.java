package net.learning.translator_kmm.android.di;

import com.squareup.sqldelight.db.SqlDriver;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import net.learning.translator_kmm.translate.domain.history.HistoryDataSource;

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
public final class AppModule_ProvideHistoryDataSourceFactory implements Factory<HistoryDataSource> {
  private final Provider<SqlDriver> driverProvider;

  public AppModule_ProvideHistoryDataSourceFactory(Provider<SqlDriver> driverProvider) {
    this.driverProvider = driverProvider;
  }

  @Override
  public HistoryDataSource get() {
    return provideHistoryDataSource(driverProvider.get());
  }

  public static AppModule_ProvideHistoryDataSourceFactory create(
      Provider<SqlDriver> driverProvider) {
    return new AppModule_ProvideHistoryDataSourceFactory(driverProvider);
  }

  public static HistoryDataSource provideHistoryDataSource(SqlDriver driver) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideHistoryDataSource(driver));
  }
}