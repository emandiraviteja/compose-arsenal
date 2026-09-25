package com.composearsenal.showcase

data class LibraryItem(
    val name: String,
    val description: String,
    val category: String,
    val version: String,
    val githubUrl: String
)

val composeArsenalLibraries = listOf(
    LibraryItem(
        name = "Awesome Button",
        description = "Powerful Material 3 buttons with variants, loading states, icons, shapes and more.",
        category = "Buttons",
        version = "1.0.0",
        githubUrl = "https://github.com/emandiraviteja/compose-arsenal/tree/main/libraries/buttons/awesome-button"
    )
)