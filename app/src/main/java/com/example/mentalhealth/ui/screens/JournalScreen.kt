package com.example.mentalhealth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mentalhealth.ui.theme.*

@Composable
fun JournalScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Digital Journal", fontWeight = FontWeight.Bold) },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BackgroundLight)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add new journal entry */ },
                containerColor = DeepPurple,
                contentColor = SoftWhite
            ) {
                Icon(Icons.Default.Add, contentDescription = "New Entry")
            }
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
                Text(
                    "Your Thoughts Matter",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
            }
            items(sampleEntries) { entry ->
                JournalEntryCard(entry)
            }
        }
    }
}

data class JournalEntry(val date: String, val title: String, val content: String, val mood: String)

val sampleEntries = listOf(
    JournalEntry("Today, 10:30 AM", "Morning Reflection", "Felt a bit anxious about the presentation but managed to calm down using the breathing app.", "😌"),
    JournalEntry("Yesterday", "Great Day!", "Had a productive study session and felt very accomplished.", "😊"),
    JournalEntry("2 days ago", "Feeling Tired", "The workload is increasing, need to manage my time better.", "😴")
)

@Composable
fun JournalEntryCard(entry: JournalEntry) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(entry.date, style = MaterialTheme.typography.labelSmall, color = TextLight)
                Text(entry.mood, style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(entry.title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(entry.content, style = MaterialTheme.typography.bodyMedium, color = TextLight, maxLines = 2)
        }
    }
}
