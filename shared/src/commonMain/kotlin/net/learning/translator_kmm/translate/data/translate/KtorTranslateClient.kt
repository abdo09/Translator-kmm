package net.learning.translator_kmm.translate.data.translate

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.utils.io.errors.IOException
import net.learning.translator_kmm.core.domain.language.Language
import net.learning.translator_kmm.translate.domain.translate.TranslateClient
import net.learning.translator_kmm.translate.domain.translate.TranslateError
import net.learning.translator_kmm.translate.domain.translate.TranslationErrorException

class KtorTranslateClient(
    private val httpClient: HttpClient
): TranslateClient {
    override suspend fun translate(
        fromLanguage: Language,
        textToTranslate: String,
        toLanguage: Language,
    ): String {
        val baseUrl = "https://translate.pl-code.com"
        val result = try {
            httpClient.post {
                url("$baseUrl/translate")
                contentType(ContentType.Application.Json)
                setBody(
                    TranslateDto(
                        textToTranslate = textToTranslate,
                        sourceLanguageCode = fromLanguage.langCode,
                        targetLanguageCode = toLanguage.langCode
                    )
                )
            }
        }catch (ex: IOException) {throw TranslationErrorException(TranslateError.SERVER_UNAVAILABLE)}

        when(result.status.value){
            in 200..299 -> Unit
            500 -> throw TranslationErrorException(TranslateError.SERVER_ERROR)
            in 400..499 -> throw TranslationErrorException(TranslateError.CLIENT_ERROR)
            else -> throw TranslationErrorException(TranslateError.UNKNOWN_ERROR)
        }

        return try {
            result.body<TranslatedDto>().translatedText
        }catch (ex: Exception){throw TranslationErrorException(TranslateError.SERVER_ERROR)}
    }
}