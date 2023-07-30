package net.learning.translator_kmm.translate.data.history

import net.learning.translator_kmm.translate.domain.history.HistoryItem
import net.learning.translatorkmm.database.HistoryEntity

fun HistoryEntity.toHistoryItem(): HistoryItem{
    return HistoryItem(
        id = id,
        fromLanguageCode = fromLanguageCode,
        fromText = fromText,
        toLanguageCode = toLanguageCode,
        toText = toText
    )
}