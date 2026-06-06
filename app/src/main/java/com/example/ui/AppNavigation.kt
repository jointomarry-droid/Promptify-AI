package com.example.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Routes {
    const val LOGIN = "login"
    const val DASHBOARD = "dashboard"
    const val HISTORY = "history"
    const val CREATE_PROMPT = "create_prompt"
    const val PRICING = "pricing"
}

@Composable
fun PromptCraftApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN,
        modifier = Modifier.fillMaxSize(),
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        }
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.DASHBOARD) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.DASHBOARD) {
            DashboardScreen(
                onNewPrompt = { navController.navigate(Routes.CREATE_PROMPT) },
                onNavigateHistory = { 
                    navController.navigate(Routes.HISTORY) {
                        popUpTo(Routes.DASHBOARD) { inclusive = false }
                    }
                },
                onUpgrade = { navController.navigate(Routes.PRICING) }
            )
        }
        composable(Routes.HISTORY) {
            HistoryScreen(
                onBack = { navController.navigateUp() },
                onNavigateDashboard = { 
                    navController.navigate(Routes.DASHBOARD) {
                        popUpTo(Routes.DASHBOARD) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.CREATE_PROMPT) {
            CreatePromptScreen(
                onBack = { navController.navigateUp() }
            )
        }
        composable(Routes.PRICING) {
            PricingScreen(
                onBack = { navController.navigateUp() }
            )
        }
    }
}
