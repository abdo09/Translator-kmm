package net.learning.translator_kmm.android.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.learning.translator_kmm.android.translate.presentaion.AndroidTranslateViewModel
import net.learning.translator_kmm.android.translate.presentaion.screens.TranslateScreen

@Composable
fun TranslateNavRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.TRANSLATE
    ){
        composable(route = Routes.TRANSLATE){
            val viewModel  = hiltViewModel<AndroidTranslateViewModel>()
            val state by viewModel.state.collectAsState()
            TranslateScreen(
                state = state,
                onEvent = viewModel::onEvent
            )

        }
    }
}