package com.example.mentalhealth.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentalhealth.ui.theme.*

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("My Profile", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BackgroundLight)
            )
        },
        containerColor = BackgroundLight
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
                // Profile Image Placeholder
                Surface(
                    modifier = Modifier
                        .size(120.dp)
                        .border(4.dp, PrimaryPastel, CircleShape),
                    shape = CircleShape,
                    color = Lavender
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.padding(24.dp),
                        tint = DeepPurple
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("Alex Johnson", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                Text("Mindfulness Enthusiast", style = MaterialTheme.typography.bodyMedium, color = TextLight)
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatItem("12", "Day Streak")
                    StatItem("45", "Meditations")
                    StatItem("850", "Zen Points")
                }
            }

            item {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = SurfaceLight),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        ProfileMenuItem(Icons.Default.Settings, "Account Settings")
                        ProfileMenuItem(Icons.Default.Notifications, "Notifications")
                        ProfileMenuItem(Icons.Default.Shield, "Privacy & Security")
                        ProfileMenuItem(Icons.Default.Help, "Help & Support")
                        Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Lavender)
                        ProfileMenuItem(Icons.Default.Logout, "Logout", textColor = Color.Red)
                    }
                }
            }
            
            item { Spacer(modifier = Modifier.height(20.dp)) }
        }
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = DeepPurple)
        Text(label, style = MaterialTheme.typography.labelSmall, color = TextLight)
    }
}

@Composable
fun ProfileMenuItem(icon: ImageVector, title: String, textColor: Color = TextDark) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = if (textColor == Color.Red) Color.Red else DeepPurple)
        Spacer(modifier = Modifier.width(16.dp))
        Text(title, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium, color = textColor)
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Lavender)
    }
}
