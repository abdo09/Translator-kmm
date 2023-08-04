package net.learning.translator_kmm.android.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import net.learning.translator_kmm.translate.domain.history.HistoryDataSource;
import net.learning.translator_kmm.translate.domain.translate.Translate;
import net.learning.translator_kmm.translate.domain.translate.TranslateClient;

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
public final class AppModule_ProvideTranslateUseCaseFactory implements Factory<Translate> {
  private final Provider<TranslateClient> clientProvider;

  private final Provider<HistoryDataSource> dataSourceProvider;

  public AppModule_ProvideTranslateUseCaseFactory(Provider<TranslateClient> clientProvider,
      Provider<HistoryDataSource> dataSourceProvider) {
    this.clientProvider = clientProvider;
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public Translate get() {
    return provideTranslateUseCase(clientProvider.get(), dataSourceProvider.get());
  }

  public static AppModule_ProvideTranslateUseCaseFactory create(
      Provider<TranslateClient> clientProvider, Provider<HistoryDataSource> dataSourceProvider) {
    return new AppModule_ProvideTranslateUseCaseFactory(clientProvider, dataSourceProvider);
  }

  public static Translate provideTranslateUseCase(TranslateClient client,
      HistoryDataSource dataSource) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTranslateUseCase(client, dataSource));
  }
}
