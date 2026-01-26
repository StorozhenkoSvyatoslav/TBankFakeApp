package com.example.tbankfakeapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun rememberScreenPadding(innerPadding: PaddingValues): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    val horizontal = 16.dp

    return PaddingValues(
        start = innerPadding.calculateStartPadding(layoutDirection) + horizontal,
        end = innerPadding.calculateEndPadding(layoutDirection) + horizontal,
        top = innerPadding.calculateTopPadding(),
        bottom = innerPadding.calculateBottomPadding()
    )
}
