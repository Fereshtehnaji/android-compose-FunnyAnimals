/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.naji.funnyAnimals.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.naji.funnyAnimals.R

/**
 * https://fonts.google.com/specimen/Montserrat
 */
private val Yekan_bakh = FontFamily(
    Font(R.font.yekan_bakh_regular),
    Font(R.font.yekan_bakh_light, FontWeight.W500),
    Font(R.font.yekan_bakh_medium, FontWeight.W600),
    Font(R.font.yekan_bakh_bold, FontWeight.Bold)
)

/**
 * https://fonts.google.com/specimen/Domine
 */
private val Domine = FontFamily(
    Font(R.font.yekan_bakh_regular),
    Font(R.font.yekan_bakh_bold, FontWeight.Bold)
)

val AnimalTypography = Typography(
    h4 = TextStyle(
        fontFamily = Yekan_bakh,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = Yekan_bakh,
        fontWeight = FontWeight.W900,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = Yekan_bakh,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Yekan_bakh,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Yekan_bakh,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = Domine,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Yekan_bakh,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Yekan_bakh,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = Yekan_bakh,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 18.sp
    ),
    overline = TextStyle(
        fontFamily = Yekan_bakh,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)
