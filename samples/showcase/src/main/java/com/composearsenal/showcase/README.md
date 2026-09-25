This README should explain that the Showcase is the **single installable demo app** for exploring Compose Arsenal libraries.

### Create this file

In Android Studio:

```text
samples
└── showcase
    ├── README.md   ← create this
    ├── build.gradle.kts
    └── src
```

Paste this complete content:

````markdown
# Compose Arsenal Showcase

The **Compose Arsenal Showcase** is the official demo application for
[Compose Arsenal](https://github.com/emandiraviteja/compose-arsenal).

It provides a single Android application where developers can explore,
interact with, and test the Compose UI libraries available in Compose Arsenal.

---

## ✨ What is the Showcase?

Instead of installing a separate sample application for every library,
Compose Arsenal provides one centralized Showcase application.

You can:

- Browse available Compose libraries
- Search libraries
- Browse libraries by category
- Open an individual library
- Interact with live components
- Test different configurations
- Preview component states and variations

---

## 📱 Current Libraries

### Buttons

#### Awesome Button

A Material 3 button component supporting:

- Variants
- Sizes
- Shapes
- Loading state
- Disabled state
- Leading icons
- Trailing icons
- Icon-only buttons
- Full-width layout
- Custom colors
- Interactive live playground

---

## 🧭 Showcase Flow

```text
Compose Arsenal
       │
       ▼
Library List
       │
       ├── Search
       │
       ├── Buttons
       │     └── Awesome Button
       │
       ├── Cards
       │
       ├── Dialogs
       │
       └── More libraries
````

Selecting a library opens its dedicated interactive showcase screen.

---

## 🎨 Design

The Showcase application uses a custom Compose Arsenal Material 3 theme.

### Theme characteristics

* Violet primary color
* Light lavender secondary surfaces
* Light background
* White rounded cards
* Material 3 components
* Consistent spacing
* Light and dark theme support

The Showcase uses the application's theme independently from the
individual library implementations.

---

## 🛠️ Tech Stack

* Kotlin
* Jetpack Compose
* Material 3
* AndroidX
* Gradle Kotlin DSL
* Android Gradle Plugin
* Compose Compiler

---

## 📂 Project Structure

```text
samples/
└── showcase/
    ├── README.md
    └── src/
        └── main/
            ├── java/
            │   └── com/
            │       └── composearsenal/
            │           └── showcase/
            │               ├── MainActivity.kt
            │               ├── LibraryItem.kt
            │               ├── LibraryListScreen.kt
            │               └── AwesomeButtonShowcaseScreen.kt
            │
            └── res/
```

---

## 🚀 Running the Showcase

Clone the repository:

```bash
git clone https://github.com/emandiraviteja/compose-arsenal.git
```

Open the project in Android Studio.

Select the `showcase` application and run it on an Android emulator
or physical Android device.

You can also build the debug APK using:

```bash
./gradlew :samples:showcase:assembleDebug
```

---

## 🧪 Purpose

The Showcase application serves two purposes:

### 1. Interactive component preview

Developers can explore the UI components and their available
configuration directly inside the application.

### 2. Library verification

The Showcase also consumes the Compose Arsenal libraries as Android
modules, helping verify that the libraries work correctly when integrated
into an Android application.

---

## 📦 Library Development

Each Compose Arsenal library is maintained independently under:

```text
libraries/
```

For example:

```text
libraries/
└── buttons/
    └── awesome-button/
```

The Showcase consumes these local library modules during development.

This allows new libraries to be developed and tested before publishing
them to a Maven repository.

---

## 🔮 Future Plans

The Showcase will gradually include more Compose Arsenal libraries,
including:

* Buttons
* Cards
* Dialogs
* Bottom Sheets
* Navigation
* Animations
* Loading
* Charts
* Calendars
* Image Components
* Text Components
* Forms
* Layouts
* OTP
* Search
* Timeline
* Stepper
* File Picker
* Other Compose utilities

---

## 🤝 Contributing

New library contributions are welcome.

Please read the repository's
[CONTRIBUTING.md](../../CONTRIBUTING.md) before submitting changes.

---

## 📄 License

Compose Arsenal is licensed under the
[Apache License 2.0](../../LICENSE).
