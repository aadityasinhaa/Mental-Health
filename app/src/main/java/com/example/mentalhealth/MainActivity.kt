package com.example.mentalhealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mentalhealth.ui.navigation.Screen
import com.example.mentalhealth.ui.screens.*
import com.example.mentalhealth.ui.theme.MentalHealthTheme
import com.example.mentalhealth.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MentalHealthTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val viewModel: MainViewModel = viewModel()

    // Primary navigation items for the Bottom Bar
    val bottomBarScreens = listOf(
        Screen.Home,
        Screen.MoodTracker,
        Screen.Chat,
        Screen.Meditation,
        Screen.Profile
    )

    Scaffold(
        bottomBar = {
            // Only show bottom bar on main dashboard screens
            val showBottomBar = currentDestination?.route in bottomBarScreens.map { it.route } || 
                               currentDestination?.route in listOf(Screen.Tasks.route, Screen.Community.route, Screen.Journal.route, Screen.Help.route)
            
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp
                ) {
                    bottomBarScreens.forEach { screen ->
                        NavigationBarItem(
                            icon = { screen.icon?.let { Icon(it, contentDescription = null) } },
                            label = { Text(screen.title) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Login.route) { LoginScreen(navController) }
            composable(Screen.Signup.route) { SignupScreen(navController) }
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.Chat.route) { ChatScreen(navController, viewModel) }
            composable(Screen.MoodTracker.route) { MoodTrackerScreen(navController, viewModel) }
            composable(Screen.Meditation.route) { MeditationScreen(navController) }
            composable(Screen.Journal.route) { JournalScreen(navController) }
            composable(Screen.Community.route) { CommunityScreen(navController) }
            composable(Screen.Help.route) { ProfessionalHelpScreen(navController) }
            composable(Screen.Tasks.route) { TasksScreen(navController) }
            composable(Screen.Profile.route) { ProfileScreen(navController) }
        }
    }
}
