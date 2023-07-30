package net.learning.translator_kmm.translate.domain.translate

import net.learning.translator_kmm.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        textToTranslate: String,
        toLanguage: Language
    ): String
}