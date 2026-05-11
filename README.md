# MindCare AI - Mental Health Support App

MindCare AI is a professional, futuristic, and emotionally calming mental health support application designed for students and young adults. It leverages AI to provide mood analysis, supportive chat, and personalized wellness recommendations.

## Tech Stack
- **UI:** Jetpack Compose (Material Design 3)
- **Architecture:** MVVM (Model-View-ViewModel)
- **Language:** Kotlin
- **Database:** Firebase Firestore
- **Auth:** Firebase Authentication
- **AI:** Google Gemini AI / OpenAI
- **Animations:** Lottie, Compose Animations
- **Navigation:** Jetpack Navigation

## Main Features
- **AI Mood Analyzer:** Analyze thoughts and detect emotional states.
- **AI Chat Support:** 24/7 empathetic AI therapist companion.
- **Mood Tracker:** Visual trends and daily mood logging.
- **Zen Mode:** Guided breathing and meditation timer.
- **Home Dashboard:** Wellness score, daily quotes, and streak tracking.
- **Professional Help:** SOS support and directory for professional counseling.

## Firebase Setup Guide
1. Create a project in the [Firebase Console](https://console.firebase.google.com/).
2. Add an Android App with package name `com.example.mentalhealth`.
3. Download the `google-services.json` file and place it in the `app/` directory.
4. Enable **Authentication** (Email/Password and Google).
5. Enable **Cloud Firestore**.
6. (Optional) Enable **Cloud Messaging** for push notifications.

## Gemini AI Integration
1. Get an API Key from [Google AI Studio](https://aistudio.google.com/).
2. Add the key to your local properties or secure storage.
3. The app uses the `generativeai` library for seamless integration.

## Design Concept
- **Colors:** Lavender (#E6E6FA), Soft Blue (#B0C4DE), Mint Green (#E0FFF0).
- **Logo Idea:** A stylized lotus flower integrated with a digital brain circuit, symbolizing the harmony between mental peace and AI technology.
- **App Icon:** A soft gradient background with a glowing white "M" shaped like a heart or a mountain peak.

## Sample AI Prompts
- "I've been feeling very overwhelmed with my exams lately and I can't sleep."
- "I feel lonely and like I don't fit in at university."
- "Can you give me a 5-minute mindfulness exercise for anxiety?"

## Project Structure
- `ui/theme`: Custom MD3 theme and glassmorphism styling.
- `ui/screens`: Individual screen composables.
- `ui/navigation`: Navigation graph and route definitions.
- `viewmodel`: Business logic and state management.
- `data`: Models and repository for Firebase/AI services.
