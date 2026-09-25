````markdown
# Contributing to Compose Arsenal

Thank you for your interest in contributing to Compose Arsenal! ❤️

Compose Arsenal is an open-source collection of reusable Jetpack Compose components, utilities, UI patterns, and libraries.

We welcome bug fixes, improvements, new components, documentation updates, and other useful contributions.

## 🚀 Getting Started

1. Fork the repository.
2. Clone your fork locally.
3. Open the project in Android Studio.
4. Create a new branch for your changes.
5. Make your changes.
6. Build and test the project.
7. Commit your changes.
8. Push your branch.
9. Open a Pull Request.

## 🌿 Branch Naming

Use a clear branch name describing your change.

Examples:

```text
feature/new-button
feature/awesome-card
fix/button-loading-state
docs/update-readme
````

## 📦 Adding a New Library

New libraries should be placed under the appropriate category inside:

```text
libraries/
```

For example:

```text
libraries/
└── buttons/
    └── awesome-button/
```

If a suitable category does not exist, use an appropriate new category.

## 🧩 Library Requirements

Each library should:

* Use Kotlin.
* Follow Jetpack Compose best practices.
* Use Material 3 where appropriate.
* Support Android API 26+ unless there is a documented reason otherwise.
* Keep the public API simple and reusable.
* Avoid unnecessary dependencies.
* Include meaningful documentation.
* Include Compose Preview examples where appropriate.
* Include a README describing the library.
* Build successfully with the project.

## 📝 Library README

Each library should have its own `README.md`.

The README should include, where applicable:

* Library name
* Description
* Features
* Installation
* Usage examples
* API information
* Requirements
* Preview
* License
* Source information

## 🎨 UI Guidelines

Components should:

* Follow Material 3 design principles where applicable.
* Be reusable and customizable.
* Avoid unnecessary hard-coded values.
* Accept `Modifier` where appropriate.
* Support standard Compose theming.
* Avoid introducing unnecessary application-specific behavior.

## 🧪 Testing

Before submitting a Pull Request:

* Build the affected library.
* Check for compilation errors.
* Test the component in a sample or preview.
* Verify that existing functionality is not broken.

## 💬 Commit Messages

Use clear and descriptive commit messages.

Examples:

```text
Add AwesomeButton loading state
Fix button click handling
Add card component
Update button documentation
```

## 🔀 Pull Requests

Please keep Pull Requests focused on a specific change.

A Pull Request should:

* Explain what was changed.
* Explain why the change was needed.
* Include relevant screenshots or previews for UI changes.
* Mention any important implementation details.
* Keep unrelated changes out of the Pull Request.

## 🐛 Bug Reports

When reporting a bug, please include:

* Library name
* Library version or commit
* Android version
* Device or emulator information
* Steps to reproduce
* Expected behavior
* Actual behavior
* Relevant code or screenshots

## 💡 Feature Requests

Feature requests are welcome.

Please explain:

* What you would like to add.
* Why it would be useful.
* How you expect it to work.
* Any relevant examples.

## 📄 License

By contributing to Compose Arsenal, you agree that your contributions will be licensed under the Apache License 2.0 used by this project.

See the root `LICENSE` file for details.

## ❤️ Thank You

Every contribution helps make Compose Arsenal more useful for the Android and Jetpack Compose community.

Thank you for contributing!
