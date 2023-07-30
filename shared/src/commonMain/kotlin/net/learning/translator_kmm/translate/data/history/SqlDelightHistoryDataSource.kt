package net.learning.translator_kmm.translate.data.history

import net.learning.translator_kmm.core.domain.util.CommonFlow
import net.learning.translator_kmm.database.TranslatorDatabase
import net.learning.translator_kmm.translate.domain.history.HistoryDataSource
import net.learning.translator_kmm.translate.domain.history.HistoryItem

class SqlDelightHistoryDataSource(
    db: TranslatorDatabase
): HistoryDataSource {
    val queries = db.translatorQueries
    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries.transactionWithResult {
            getHistory()
        }
    }

    override suspend fun insertHistoryItem(historyItem: HistoryItem) {
        TODO("Not yet implemented")
    }
}
