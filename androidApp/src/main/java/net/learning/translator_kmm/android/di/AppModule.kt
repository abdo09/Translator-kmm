package net.learning.translator_kmm.android.di

import android.app.Application
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import net.learning.translator_kmm.database.TranslatorDatabase
import net.learning.translator_kmm.translate.data.history.SqlDelightHistoryDataSource
import net.learning.translator_kmm.translate.data.local.DatabaseDriverFactory
import net.learning.translator_kmm.translate.data.translate.KtorTranslateClient
import net.learning.translator_kmm.translate.domain.history.HistoryDataSource
import net.learning.translator_kmm.translate.domain.translate.Translate
import net.learning.translator_kmm.translate.domain.translate.TranslateClient
import net.learning.translator_kmm.translate.remote.HttpClientFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient{
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient{
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideTranslateDriver(app: Application): SqlDriver{
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource{
        return SqlDelightHistoryDataSource(TranslatorDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): Translate{
        return Translate(client = client, dataSource = dataSource)
    }

}