package com.example.mentalhealth.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentalhealth.ui.theme.*
import com.example.mentalhealth.ui.viewmodel.MainViewModel

@Composable
fun MoodTrackerScreen(navController: NavController, viewModel: MainViewModel) {
    var selectedMood by remember { mutableStateOf<String?>(null) }
    val moods = listOf(
        "😊" to "Happy",
        "😐" to "Neutral",
        "😔" to "Sad",
        "😠" to "Angry",
        "😴" to "Tired",
        "😰" to "Anxious"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Mood Tracker", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BackgroundLight)
            )
        },
        containerColor = BackgroundLight
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "How are you feeling right now?",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Medium,
                color = TextDark
            )
            Spacer(modifier = Modifier.height(24.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(moods) { (emoji, label) ->
                    MoodItem(
                        emoji = emoji,
                        label = label,
                        isSelected = selectedMood == label,
                        onClick = { selectedMood = label }
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            MoodTrendsCard()

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { 
                    selectedMood?.let { mood ->
                        viewModel.logMood(moods.find { it.second == mood }?.first ?: "😊", mood)
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DeepPurple),
                enabled = selectedMood != null
            ) {
                Text("Log Mood", fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun MoodItem(emoji: String, label: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(4.dp)
    ) {
        Surface(
            shape = CircleShape,
            color = if (isSelected) PrimaryPastel else SurfaceLight,
            modifier = Modifier.size(64.dp),
            shadowElevation = if (isSelected) 8.dp else 2.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(emoji, fontSize = 32.sp)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            label,
            style = MaterialTheme.typography.labelMedium,
            color = if (isSelected) DeepPurple else TextLight,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
fun MoodTrendsCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("Weekly Trends", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth().height(150.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                val heights = listOf(0.4f, 0.6f, 0.8f, 0.5f, 0.9f, 0.7f, 0.6f)
                val days = listOf("M", "T", "W", "T", "F", "S", "S")
                
                heights.forEachIndexed { index, height ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .width(12.dp)
                                .fillMaxHeight(height)
                                .background(
                                    brush = Brush.verticalGradient(listOf(DeepPurple, PrimaryPastel)),
                                    shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)
                                )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(days[index], style = MaterialTheme.typography.labelSmall, color = TextLight)
                    }
                }
            }
        }
    }
}
