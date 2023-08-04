package net.learning.translator_kmm.android.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007\u00a8\u0006\u0013"}, d2 = {"Lnet/learning/translator_kmm/android/di/AppModule;", "", "()V", "provideHistoryDataSource", "Lnet/learning/translator_kmm/translate/domain/history/HistoryDataSource;", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", "provideHttpClient", "Lio/ktor/client/HttpClient;", "provideTranslateClient", "Lnet/learning/translator_kmm/translate/domain/translate/TranslateClient;", "httpClient", "provideTranslateDriver", "app", "Landroid/app/Application;", "provideTranslateUseCase", "Lnet/learning/translator_kmm/translate/domain/translate/Translate;", "client", "dataSource", "androidApp_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final net.learning.translator_kmm.android.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final io.ktor.client.HttpClient provideHttpClient() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final net.learning.translator_kmm.translate.domain.translate.TranslateClient provideTranslateClient(@org.jetbrains.annotations.NotNull
    io.ktor.client.HttpClient httpClient) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.squareup.sqldelight.db.SqlDriver provideTranslateDriver(@org.jetbrains.annotations.NotNull
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final net.learning.translator_kmm.translate.domain.history.HistoryDataSource provideHistoryDataSource(@org.jetbrains.annotations.NotNull
    com.squareup.sqldelight.db.SqlDriver driver) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final net.learning.translator_kmm.translate.domain.translate.Translate provideTranslateUseCase(@org.jetbrains.annotations.NotNull
    net.learning.translator_kmm.translate.domain.translate.TranslateClient client, @org.jetbrains.annotations.NotNull
    net.learning.translator_kmm.translate.domain.history.HistoryDataSource dataSource) {
        return null;
    }
}