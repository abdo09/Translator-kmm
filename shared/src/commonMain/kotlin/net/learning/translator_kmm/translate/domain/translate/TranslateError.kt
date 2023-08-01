package net.learning.translator_kmm.translate.domain.translate

enum class TranslateError{
    SERVER_UNAVAILABLE,
    CLIENT_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR
}

class TranslationErrorException(val error:  TranslateError): Exception(
    "An error occurred when translating:$error"
)