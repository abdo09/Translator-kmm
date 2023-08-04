package net.learning.translator_kmm.android.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.ktor.client.HttpClient;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
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
public final class AppModule_ProvideTranslateClientFactory implements Factory<TranslateClient> {
  private final Provider<HttpClient> httpClientProvider;

  public AppModule_ProvideTranslateClientFactory(Provider<HttpClient> httpClientProvider) {
    this.httpClientProvider = httpClientProvider;
  }

  @Override
  public TranslateClient get() {
    return provideTranslateClient(httpClientProvider.get());
  }

  public static AppModule_ProvideTranslateClientFactory create(
      Provider<HttpClient> httpClientProvider) {
    return new AppModule_ProvideTranslateClientFactory(httpClientProvider);
  }

  public static TranslateClient provideTranslateClient(HttpClient httpClient) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTranslateClient(httpClient));
  }
}
