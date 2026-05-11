package com.example.mentalhealth.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mentalhealth.data.model.ChatMessage
import com.example.mentalhealth.data.model.MoodEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<ChatMessage>>(listOf(
        ChatMessage(text = "Hello! I'm MindCare AI. How are you feeling today?", isUser = false)
    ))
    val messages: StateFlow<List<ChatMessage>> = _messages

    private val _moodHistory = MutableStateFlow<List<MoodEntry>>(emptyList())
    val moodHistory: StateFlow<List<MoodEntry>> = _moodHistory

    fun sendMessage(text: String) {
        val userMsg = ChatMessage(text = text, isUser = true)
        _messages.value = _messages.value + userMsg
        
        // Simulate AI Response
        viewModelScope.launch {
            val aiResponse = ChatMessage(text = "I hear you. It sounds like you're going through a lot. Remember that it's okay to feel this way, and I'm here to support you.", isUser = false)
            _messages.value = _messages.value + aiResponse
        }
    }

    fun logMood(emoji: String, label: String) {
        val entry = MoodEntry(emoji = emoji, label = label)
        _moodHistory.value = _moodHistory.value + entry
    }
}
