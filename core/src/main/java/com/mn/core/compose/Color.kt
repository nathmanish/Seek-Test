package com.mn.core.compose

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Light Color
private val BackgroundBrand = Color(0xFF0D3880)
private val BackgroundSecondary = Color(0xFFEFF3FB)
private val CardBackground = Color(0xFFFFFFFF)
private val TextPrimary = Color(0xFF333A49)
private val TextSecondary = Color(0xFF69768C)
private val TextReversed = Color(0xFFFFFFFF)
private val Button = Color(0xFF2765CF)
private val WhiteColor = Color(0xFFFFFFFF)
private val BlackTransparent = Color(0x80000000)

val ColorScheme.backgroundBrand: Color
    get() = BackgroundBrand

val ColorScheme.backgroundSecondary: Color
    get() = BackgroundSecondary

val ColorScheme.cardBackground: Color
    get() = CardBackground

val ColorScheme.textPrimary: Color
    get() = TextPrimary

val ColorScheme.textSecondary: Color
    get() = TextSecondary

val ColorScheme.textReversed: Color
    get() = TextReversed

val ColorScheme.brandBlue: Color
    get() = BackgroundBrand

val ColorScheme.blue: Color
    get() = button

val ColorScheme.button: Color
    get() = Button

val ColorScheme.white: Color
    get() = WhiteColor

val ColorScheme.blackTransparent : Color
    get() = BlackTransparent

val ColorScheme.blueButton: List<Color>
    get() = listOf(button, button)

val ColorScheme.grayButton: List<Color>
    get() = listOf(TextReversed, TextReversed)

val ColorScheme.disableButton: List<Color>
    get() = listOf(TextSecondary, TextSecondary)

val Pink80 = Color(0xFFEFB8C8)

val Pink40 = Color(0xFF7D5260)

val DarkColorScheme = darkColorScheme(
    primary = BackgroundBrand,
    secondary = BackgroundSecondary,
    tertiary = Pink80,
)

val LightColorScheme = lightColorScheme(
    primary = BackgroundBrand,
    secondary = BackgroundSecondary,
    tertiary = Pink40
)