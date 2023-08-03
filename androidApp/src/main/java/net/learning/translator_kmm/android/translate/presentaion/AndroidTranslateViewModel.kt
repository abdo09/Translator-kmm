package net.learning.translator_kmm.android.translate.presentaion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import net.learning.translator_kmm.presentation.TranslateEvent
import net.learning.translator_kmm.presentation.TranslateViewModel
import net.learning.translator_kmm.translate.domain.history.HistoryDataSource
import net.learning.translator_kmm.translate.domain.translate.Translate

@HiltViewModel
class AndroidTranslateViewModel(
    private val translate: Translate,
    private val historyDataSource: HistoryDataSource
) : ViewModel(){

    val viewModel by lazy {
        TranslateViewModel(
            translate,
            historyDataSource,
            viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent){
        viewModel.onEvent(event)
    }

}