package net.learning.translator_kmm.core.domain.language

expect class UiLanguage {
    expect val language: Language

    companion object{
        fun byCode(langCode: String): UiLanguage
        val allLanguages: List<UiLanguage>
    }
}