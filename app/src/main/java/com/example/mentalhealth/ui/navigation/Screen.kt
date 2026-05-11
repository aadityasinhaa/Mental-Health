package com.example.mentalhealth.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector? = null) {
    object Login : Screen("login", "Login")
    object Signup : Screen("signup", "Signup")
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Chat : Screen("chat", "AI Chat", Icons.Default.Chat)
    object MoodTracker : Screen("mood", "Mood", Icons.Default.Favorite)
    object Meditation : Screen("meditation", "Zen", Icons.Default.SelfImprovement)
    object Journal : Screen("journal", "Journal", Icons.Default.Book)
    object Community : Screen("community", "Community", Icons.Default.Groups)
    object Help : Screen("help", "Help", Icons.Default.MedicalServices)
    object Tasks : Screen("tasks", "Tasks", Icons.Default.CheckCircle)
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
}
