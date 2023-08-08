package net.learning.translator_kmm.android.core.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.learning.translator_kmm.android.translate.presentaion.AndroidTranslateViewModel
import net.learning.translator_kmm.android.translate.presentaion.screens.TranslateScreen
import net.learning.translator_kmm.presentation.TranslateEvent

@Composable
fun TranslateNavRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.TRANSLATE
    ) {
        composable(route = Routes.TRANSLATE) {
            val viewModel = hiltViewModel<AndroidTranslateViewModel>()
            val state by viewModel.state.collectAsState()
            TranslateScreen(
                state = state,
                onEvent = { event ->
                    when (event) {
                        is TranslateEvent.RecordAudio -> {
                            navController.navigate(
                                Routes.VOICE_TO_TEXT + "/${state.fromLanguage.language.langCode}"
                            )
                        }

                        else -> viewModel.onEvent(event)
                    }
                }
            )

        }

        composable(
            route = Routes.VOICE_TO_TEXT + "/{${Arguments.LANG_CODE}}",
            arguments = listOf(
                navArgument(Arguments.LANG_CODE) {
                    type = NavType.StringType
                    defaultValue = "en"
                }
            )
        ) {
            Text(text = it.arguments?.getString(Arguments.LANG_CODE) ?: "en")

        }
    }
}