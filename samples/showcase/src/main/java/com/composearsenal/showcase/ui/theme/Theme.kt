package com.composearsenal.showcase.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = ArsenalPurple80,
    onPrimary = Color.Black,

    primaryContainer = ArsenalPurple,
    onPrimaryContainer = Color.White,

    secondary = ArsenalPurpleGrey80,
    onSecondary = Color.Black,

    tertiary = ArsenalPink80,

    background = ArsenalDarkBackground,
    onBackground = ArsenalDarkTextPrimary,

    surface = ArsenalDarkSurface,
    onSurface = ArsenalDarkTextPrimary,

    surfaceVariant = ArsenalDarkSurfaceVariant,
    onSurfaceVariant = ArsenalDarkTextSecondary,

    error = ArsenalError,
    onError = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = ArsenalPurple,
    onPrimary = Color.White,

    primaryContainer = ArsenalLavender,
    onPrimaryContainer = ArsenalPurpleDark,

    secondary = ArsenalPurpleLight,
    onSecondary = Color.White,

    tertiary = ArsenalPurpleDark,
    onTertiary = Color.White,

    background = ArsenalBackground,
    onBackground = ArsenalTextPrimary,

    surface = ArsenalSurface,
    onSurface = ArsenalTextPrimary,

    surfaceVariant = ArsenalLavender,
    onSurfaceVariant = ArsenalTextSecondary,

    error = ArsenalError,
    onError = Color.White
)

@Composable
fun ComposeArsenalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}