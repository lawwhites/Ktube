package com.ktube

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ktube.channel.ChannelScreen
import com.ktube.favorites.FavoritesScreen
import com.ktube.history.HistoryScreen
import com.ktube.home.HomeScreen
import com.ktube.playlist.PlaylistScreen
import com.ktube.player.PlayerScreen
import com.ktube.search.SearchScreen
import com.ktube.settings.SettingsScreen
import com.ktube.subscriptions.SubscriptionsScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.HOME
    ) {
        composable(AppRoutes.HOME) {
            HomeScreen(
                onOpenPlayer = { navController.navigate(AppRoutes.PLAYER) },
                onOpenSearch = { navController.navigate(AppRoutes.SEARCH) },
                onOpenSettings = { navController.navigate(AppRoutes.SETTINGS) },
                onOpenHistory = { navController.navigate(AppRoutes.HISTORY) },
                onOpenChannel = { navController.navigate(AppRoutes.CHANNEL) },
                onOpenPlaylist = { navController.navigate(AppRoutes.PLAYLIST) },
                onOpenFavorites = { navController.navigate(AppRoutes.FAVORITES) },
                onOpenSubscriptions = { navController.navigate(AppRoutes.SUBSCRIPTIONS) }
            )
        }

        composable(AppRoutes.SEARCH) { SearchScreen(onBack = { navController.popBackStack() }) }
        composable(AppRoutes.SETTINGS) { SettingsScreen(onBack = { navController.popBackStack() }) }
        composable(AppRoutes.PLAYER) { PlayerScreen(onBack = { navController.popBackStack() }) }
        composable(AppRoutes.HISTORY) { HistoryScreen(onBack = { navController.popBackStack() }) }
        composable(AppRoutes.CHANNEL) { ChannelScreen(onBack = { navController.popBackStack() }) }
        composable(AppRoutes.PLAYLIST) { PlaylistScreen(onBack = { navController.popBackStack() }) }
        composable(AppRoutes.FAVORITES) { FavoritesScreen(onBack = { navController.popBackStack() }) }
        composable(AppRoutes.SUBSCRIPTIONS) { SubscriptionsScreen(onBack = { navController.popBackStack() }) }
    }
}
