package net.learning.translator_kmm.translate.domain.history

import net.learning.translator_kmm.core.domain.util.CommonFlow

interface HistoryDataSource {

    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(historyItem: HistoryItem)

}