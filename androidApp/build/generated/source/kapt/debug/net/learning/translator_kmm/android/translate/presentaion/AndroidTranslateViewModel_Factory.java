package net.learning.translator_kmm.android.translate.presentaion;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import net.learning.translator_kmm.translate.domain.history.HistoryDataSource;
import net.learning.translator_kmm.translate.domain.translate.Translate;

@ScopeMetadata
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
public final class AndroidTranslateViewModel_Factory implements Factory<AndroidTranslateViewModel> {
  private final Provider<Translate> translateProvider;

  private final Provider<HistoryDataSource> historyDataSourceProvider;

  public AndroidTranslateViewModel_Factory(Provider<Translate> translateProvider,
      Provider<HistoryDataSource> historyDataSourceProvider) {
    this.translateProvider = translateProvider;
    this.historyDataSourceProvider = historyDataSourceProvider;
  }

  @Override
  public AndroidTranslateViewModel get() {
    return newInstance(translateProvider.get(), historyDataSourceProvider.get());
  }

  public static AndroidTranslateViewModel_Factory create(Provider<Translate> translateProvider,
      Provider<HistoryDataSource> historyDataSourceProvider) {
    return new AndroidTranslateViewModel_Factory(translateProvider, historyDataSourceProvider);
  }

  public static AndroidTranslateViewModel newInstance(Translate translate,
      HistoryDataSource historyDataSource) {
    return new AndroidTranslateViewModel(translate, historyDataSource);
  }
}
