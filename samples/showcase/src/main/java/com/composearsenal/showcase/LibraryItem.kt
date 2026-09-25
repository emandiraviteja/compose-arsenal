package com.composearsenal.showcase

data class LibraryItem(
    val name: String,
    val description: String,
    val category: String
)

val composeArsenalLibraries = listOf(
    LibraryItem(
        name = "Awesome Button",
        description = "Powerful Material 3 buttons with variants, loading states, icons, shapes and more.",
        category = "Buttons"
    )
)