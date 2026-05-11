package com.example.mentalhealth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Emergency
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentalhealth.ui.theme.*

@Composable
fun ProfessionalHelpScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Professional Help", fontWeight = FontWeight.Bold) },
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
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.Emergency, contentDescription = null, tint = Color.Red, modifier = Modifier.size(48.dp))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Emergency SOS", fontWeight = FontWeight.Bold, color = Color.Red, fontSize = 20.sp)
                        Text("If you're in immediate danger, please call emergency services.", textAlign = androidx.compose.ui.text.style.TextAlign.Center, color = TextDark)
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { /* Call Emergency */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Call, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Call Helpline Now")
                        }
                    }
                }
            }

            item {
                Text("Nearby Counseling Centers", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            }

            items(sampleCenters) { center ->
                HelpCenterCard(center)
            }
        }
    }
}

data class HelpCenter(val name: String, val address: String, val distance: String)

val sampleCenters = listOf(
    HelpCenter("City Wellness Center", "123 Health Ave, Downtown", "1.2 km"),
    HelpCenter("Mindful Living Hub", "456 Peace St, Northside", "3.5 km"),
    HelpCenter("Student Support Services", "University Campus, Building B", "0.5 km")
)

@Composable
fun HelpCenterCard(center: HelpCenter) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = DeepPurple, modifier = Modifier.size(32.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(center.name, fontWeight = FontWeight.Bold)
                Text(center.address, style = MaterialTheme.typography.labelSmall, color = TextLight)
            }
            Text(center.distance, fontWeight = FontWeight.Bold, color = DeepPurple, fontSize = 12.sp)
        }
    }
}
