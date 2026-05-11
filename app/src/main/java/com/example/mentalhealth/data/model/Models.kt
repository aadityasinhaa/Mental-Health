package com.example.mentalhealth.data.model

import java.util.Date

data class UserProfile(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val wellnessScore: Int = 0,
    val streak: Int = 0
)

data class MoodEntry(
    val id: String = "",
    val emoji: String = "",
    val label: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val note: String = ""
)

data class ChatMessage(
    val id: String = "",
    val text: String = "",
    val isUser: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)

data class CommunityPost(
    val id: String = "",
    val content: String = "",
    val authorName: String = "Anonymous",
    val likes: Int = 0,
    val timestamp: Long = System.currentTimeMillis()
)

data class SelfCareTask(
    val id: String = "",
    val title: String = "",
    val category: String = "",
    val isCompleted: Boolean = false
)
