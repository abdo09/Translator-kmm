package net.learning.translator_kmm.translate.data.history

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock
import net.learning.translator_kmm.core.domain.util.CommonFlow
import net.learning.translator_kmm.core.domain.util.toCommonFlow
import net.learning.translator_kmm.database.TranslatorDatabase
import net.learning.translator_kmm.translate.domain.history.HistoryDataSource
import net.learning.translator_kmm.translate.domain.history.HistoryItem

class SqlDelightHistoryDataSource(
    db: TranslatorDatabase
): HistoryDataSource {
    private val queries = db.translatorQueries
    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries.getHistory()
            .asFlow()
            .mapToList()
            .map { history ->
                history.map { it.toHistoryItem() }
            }
            .toCommonFlow()
    }

    override suspend fun insertHistoryItem(historyItem: HistoryItem) {
        queries.insertHistoryEntity(
            id = historyItem.id,
            fromLanguageCode = historyItem.fromLanguageCode,
            fromText = historyItem.fromText,
            toLanguageCode = historyItem.toLanguageCode,
            toText = historyItem.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}
