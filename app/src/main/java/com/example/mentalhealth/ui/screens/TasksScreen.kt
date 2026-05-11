@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.example.mentalhealth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mentalhealth.ui.theme.*

@Composable
fun TasksScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Daily Challenges", fontWeight = FontWeight.Bold) },
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                DailyProgressCard()
            }
            item {
                Text("Self-Care Tasks", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            }
            items(sampleTasks) { task ->
                TaskItem(task)
            }
        }
    }
}

data class CareTask(val title: String, val points: String, var isDone: Boolean = false)

val sampleTasks = listOf(
    CareTask("Drink 2L of water", "10 pts"),
    CareTask("5-minute morning stretch", "15 pts"),
    CareTask("Write 3 things you're grateful for", "20 pts"),
    CareTask("No social media for 1 hour", "25 pts"),
    CareTask("Connect with a friend", "15 pts")
)

@Composable
fun DailyProgressCard() {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = DeepPurple),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, contentDescription = null, tint = Color.Yellow)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Level 5 Explorer", color = Color.White, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(12.dp))
            LinearProgressIndicator(
                progress = 0.7f,
                modifier = Modifier.fillMaxWidth().height(8.dp),
                color = PrimaryPastel,
                trackColor = Color.White.copy(alpha = 0.3f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("150 / 200 XP to next level", color = SoftWhite, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
fun TaskItem(task: CareTask) {
    var checked by remember { mutableStateOf(task.isDone) }
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { checked = !checked }) {
                Icon(
                    if (checked) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                    contentDescription = null,
                    tint = if (checked) Color(0xFF4CAF50) else DeepPurple
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    task.title,
                    fontWeight = FontWeight.Medium,
                    style = if (checked) MaterialTheme.typography.bodyMedium.copy(textDecoration = androidx.compose.ui.text.style.TextDecoration.LineThrough) else MaterialTheme.typography.bodyMedium
                )
                Text(task.points, style = MaterialTheme.typography.labelSmall, color = DeepPurple)
            }
        }
    }
}
