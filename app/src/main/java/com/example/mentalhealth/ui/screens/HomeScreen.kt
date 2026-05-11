package com.example.mentalhealth.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentalhealth.ui.theme.*

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Hello, Alex", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Text("How are you feeling today?", style = MaterialTheme.typography.bodySmall, color = TextLight)
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        },
        containerColor = BackgroundLight
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                QuoteCard()
            }
            item {
                WellnessScoreCard()
            }
            item {
                Text("Daily Activities", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            }
            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    ActivityCard("Meditation", "10 mins", TertiaryPastel, Modifier.weight(1f))
                    ActivityCard("Journal", "Daily Entry", SecondaryPastel, Modifier.weight(1f))
                }
            }
            item {
                StressLevelIndicator()
            }
            item { Spacer(modifier = Modifier.height(20.dp)) }
        }
    }
}

@Composable
fun QuoteCard() {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = PrimaryPastel.copy(alpha = 0.3f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.WbSunny,
                contentDescription = null,
                tint = DeepPurple,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    "\"The best way to predict the future is to create it.\"",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                )
                Text("- Abraham Lincoln", style = MaterialTheme.typography.labelSmall, color = TextLight)
            }
        }
    }
}

@Composable
fun WellnessScoreCard() {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("Wellness Score", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(
                        brush = Brush.sweepGradient(listOf(PrimaryPastel, SecondaryPastel, PrimaryPastel)),
                        shape = RoundedCornerShape(60.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier.size(100.dp),
                    shape = RoundedCornerShape(50.dp),
                    color = SurfaceLight
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text("85%", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = DeepPurple)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "You're doing great! Keep up your daily habits to maintain your mental balance.",
                style = MaterialTheme.typography.bodySmall,
                color = TextLight,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
fun ActivityCard(title: String, subtitle: String, color: Color, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.2f)),
        modifier = modifier.height(120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(title, fontWeight = FontWeight.Bold, color = TextDark)
            Text(subtitle, style = MaterialTheme.typography.labelMedium, color = TextLight)
        }
    }
}

@Composable
fun StressLevelIndicator() {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("Stress Level", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            LinearProgressIndicator(
                progress = 0.4f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = PrimaryPastel,
                trackColor = Lavender
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Low Stress", style = MaterialTheme.typography.labelSmall, color = Color(0xFF4CAF50))
        }
    }
}
