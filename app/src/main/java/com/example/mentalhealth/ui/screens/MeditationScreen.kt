@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.example.mentalhealth.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentalhealth.ui.theme.*

@Composable
fun MeditationScreen(navController: NavController) {
    var isBreathing by remember { mutableStateOf(false) }
    
    val infiniteTransition = rememberInfiniteTransition(label = "breathing")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Zen Mode", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BackgroundLight)
            )
        },
        containerColor = BackgroundLight
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                if (isBreathing) "Breathe In... and Out" else "Ready to Relax?",
                style = MaterialTheme.typography.headlineMedium,
                color = DeepPurple,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(60.dp))

            Box(contentAlignment = Alignment.Center) {
                // Outer circle (Background)
                Surface(
                    modifier = Modifier
                        .size(200.dp)
                        .scale(if (isBreathing) scale else 1f),
                    shape = CircleShape,
                    color = PrimaryPastel.copy(alpha = 0.3f)
                ) {}
                
                // Middle circle
                Surface(
                    modifier = Modifier
                        .size(150.dp)
                        .scale(if (isBreathing) scale * 0.8f else 0.8f),
                    shape = CircleShape,
                    color = SecondaryPastel.copy(alpha = 0.5f)
                ) {}

                // Inner circle
                Surface(
                    modifier = Modifier.size(100.dp),
                    shape = CircleShape,
                    color = DeepPurple,
                    shadowElevation = 8.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        IconButton(onClick = { isBreathing = !isBreathing }) {
                            Icon(
                                if (isBreathing) Icons.Default.Pause else Icons.Default.PlayArrow,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(80.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                MeditationOption("Deep Sleep", "15 min")
                MeditationOption("Focus", "10 min")
            }
        }
    }
}

@Composable
fun MeditationOption(title: String, duration: String) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        modifier = Modifier.width(150.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.Bold, color = TextDark)
            Text(duration, style = MaterialTheme.typography.labelSmall, color = TextLight)
        }
    }
}
