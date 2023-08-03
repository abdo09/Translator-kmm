package net.learning.translator_kmm.android.translate.presentaion;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lnet/learning/translator_kmm/android/translate/presentaion/AndroidTranslateViewModel;", "Landroidx/lifecycle/ViewModel;", "translate", "Lnet/learning/translator_kmm/translate/domain/translate/Translate;", "historyDataSource", "Lnet/learning/translator_kmm/translate/domain/history/HistoryDataSource;", "(Lnet/learning/translator_kmm/translate/domain/translate/Translate;Lnet/learning/translator_kmm/translate/domain/history/HistoryDataSource;)V", "state", "Lnet/learning/translator_kmm/core/domain/util/CommonStateFlow;", "Lnet/learning/translator_kmm/presentation/TranslateState;", "getState", "()Lnet/learning/translator_kmm/core/domain/util/CommonStateFlow;", "viewModel", "Lnet/learning/translator_kmm/presentation/TranslateViewModel;", "getViewModel", "()Lnet/learning/translator_kmm/presentation/TranslateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onEvent", "", "event", "Lnet/learning/translator_kmm/presentation/TranslateEvent;", "androidApp_debug"})
public final class AndroidTranslateViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final net.learning.translator_kmm.translate.domain.translate.Translate translate = null;
    @org.jetbrains.annotations.NotNull
    private final net.learning.translator_kmm.translate.domain.history.HistoryDataSource historyDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final net.learning.translator_kmm.core.domain.util.CommonStateFlow<net.learning.translator_kmm.presentation.TranslateState> state = null;
    
    public AndroidTranslateViewModel(@org.jetbrains.annotations.NotNull
    net.learning.translator_kmm.translate.domain.translate.Translate translate, @org.jetbrains.annotations.NotNull
    net.learning.translator_kmm.translate.domain.history.HistoryDataSource historyDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final net.learning.translator_kmm.presentation.TranslateViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final net.learning.translator_kmm.core.domain.util.CommonStateFlow<net.learning.translator_kmm.presentation.TranslateState> getState() {
        return null;
    }
    
    public final void onEvent(@org.jetbrains.annotations.NotNull
    net.learning.translator_kmm.presentation.TranslateEvent event) {
    }
}