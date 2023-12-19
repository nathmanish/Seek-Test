package com.mn.core.compose

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.kaaveh.sdpcompose.ssp


val Typography.headline6: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.ssp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

val Typography.headline7: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.ssp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

val Typography.body2: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 10.ssp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.2).sp
    )


val Typography.caption1: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.ssp,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

val Typography.caption2: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.ssp,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

val Typography.caption3: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 10.ssp,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )


val Typography.button: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.ssp,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

// My custom added text-styles
val Typography.title1: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 24.ssp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

val Typography.title2: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 20.ssp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

val Typography.title3: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 18.ssp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

val Typography.title4: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.ssp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

val Typography.title5: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.ssp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )

val Typography.title6: TextStyle
    @Composable get() = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.ssp,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Normal,
        letterSpacing = (0.4).sp
    )


// Set of Material typography styles to start with
val SeekTypography: Typography
    @Composable get() = Typography(
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.ssp,
            lineHeight = 24.ssp,
            letterSpacing = 0.5.sp
        ),
    )