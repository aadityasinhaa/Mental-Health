package com.example.mentalhealth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mentalhealth.ui.theme.*

@Composable
fun CommunityScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Community Support", fontWeight = FontWeight.Bold) },
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
                Text(
                    "Safe Space for Everyone",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
            }
            items(samplePosts) { post ->
                CommunityPostCard(post)
            }
        }
    }
}

data class Post(val author: String, val content: String, val time: String, val likes: Int)

val samplePosts = listOf(
    Post("Anonymous", "Just wanted to share that today was a better day. Small wins count! 🌟", "2h ago", 24),
    Post("BraveSoul", "Does anyone have tips for managing exam stress? I'm feeling a bit overwhelmed.", "5h ago", 12),
    Post("PeaceSeeker", "Tried the guided meditation today, it really helped me stay grounded.", "1d ago", 45)
)

@Composable
fun CommunityPostCard(post: Post) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = PrimaryPastel.copy(alpha = 0.5f),
                    modifier = Modifier.size(32.dp)
                ) {}
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(post.author, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                    Text(post.time, style = MaterialTheme.typography.labelSmall, color = TextLight)
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(post.content, style = MaterialTheme.typography.bodyMedium, color = TextDark)
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = DeepPurple, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("${post.likes}", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.width(20.dp))
                Icon(Icons.Default.ChatBubbleOutline, contentDescription = null, tint = DeepPurple, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Reply", style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}
