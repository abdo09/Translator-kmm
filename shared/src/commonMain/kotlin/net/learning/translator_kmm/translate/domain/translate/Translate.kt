package net.learning.translator_kmm.translate.domain.translate

import io.ktor.client.HttpClient
import net.learning.translator_kmm.core.domain.language.Language
import net.learning.translator_kmm.core.domain.util.Resource
import net.learning.translator_kmm.translate.domain.history.HistoryDataSource
import net.learning.translator_kmm.translate.domain.history.HistoryItem

class Translate(
    private val client: TranslateClient,
    private val dataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language,
    ): Resource<String>{
        return try {
            val translatedText = client.translate(
                fromLanguage = fromLanguage, fromText = fromText, toLanguage = toLanguage
            )

            dataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText
                )
            )

            Resource.Success(translatedText)

        }catch (ex: TranslationErrorException){
            ex.printStackTrace()
            Resource.Error(ex)
        }
    }
}