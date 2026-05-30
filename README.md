# Aagama 2K18

Android app for **Aagama 2K18**, the annual technical and cultural fest of Anurag Group of Institutions (March 16–17, 2018). The app lets attendees browse events across all departments, read event rules and coordinator contacts, and register via embedded Google Forms links.

## Features

- Animated splash screen with onboarding walkthrough
- Countdown timer to the event start date
- Department-wise event listings: CSE, ECE, EEE, Civil, MECH, IT, Pharmacy, Chemical
- Per-event detail screens with description, rules, and coordinator contacts
- In-app Google Forms registration for every event
- About section with fest overview
- One-tap Google Maps directions to the venue
- BoomMenu floating action button for quick navigation

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java |
| Platform | Android (minSdk 16 / targetSdk 26) |
| Build | Gradle 4.x + Android Gradle Plugin 3.0.1 |
| UI | Android Support Library 26.1.0, ConstraintLayout, CardView, TabLayout, ViewPager |
| Image loading | Universal Image Loader 1.9.5 |
| Animations | Konfetti 1.1.0, custom `res/anim/` XML animations |
| Navigation | BoomMenu 2.1.1 |
| Onboarding | Tutorial-View v1.0.3 |
| Typography | JustifyText 1.1 |
| Avatars | CircleImageView 2.2.0 |

## Prerequisites

- **JDK 8** or later
- **Android Studio 3.0+** (or any IDE with Android Gradle support)
- **Android SDK** with API level 26 platform and build tools installed

## Getting Started

### Installation

```bash
git clone https://github.com/<your-username>/AagamaApp.git
cd AagamaApp
```

Open the project in Android Studio, let Gradle sync, then run on a device or emulator (API 16+).

### Running the App

**From Android Studio:** Click **Run ▶** or press `Shift+F10`.

**From the command line:**

```bash
# Debug build
./gradlew assembleDebug

# Install on a connected device
./gradlew installDebug
```

The generated APK is written to `app/build/outputs/apk/debug/`.

## Available Scripts

| Command | Description |
|---------|-------------|
| `./gradlew assembleDebug` | Build a debug APK |
| `./gradlew assembleRelease` | Build a release APK (requires signing config) |
| `./gradlew installDebug` | Build and install debug APK on connected device |
| `./gradlew test` | Run unit tests |
| `./gradlew connectedAndroidTest` | Run instrumented tests on a device |
| `./gradlew clean` | Delete build outputs |

## License

No license file is present in this repository.
