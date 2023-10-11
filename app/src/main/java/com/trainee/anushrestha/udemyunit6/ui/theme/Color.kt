package com.trainee.anushrestha.udemyunit6.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

/**
    Adding colors manually
 */
val AddedColor = Color(0x60DCDCDC)

val ActiveColor = Color(0x9932CD32) //for using color of own choice

val TryC = Color(0x3232ffff)

val ColorScheme.activeColor : Color
    @Composable
    get()= ActiveColor

val ColorScheme.tryColor : Color
@Composable
get() = TryC