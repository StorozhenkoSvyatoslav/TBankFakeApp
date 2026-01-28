package com.example.tbankfakeapp.ui.screens

import android.R.attr.start
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tbankfakeapp.R
import com.example.tbankfakeapp.ui.components.SearchField
import com.example.tbankfakeapp.ui.components.mainscreen.MainScreenProfile
import com.example.tbankfakeapp.ui.components.mainscreen.PromoCard
import com.example.tbankfakeapp.ui.components.mainscreen.PromoCardRow
import com.example.tbankfakeapp.ui.components.rememberScreenPadding
import com.example.tbankfakeapp.ui.theme.AppColors
import com.example.tbankfakeapp.ui.theme.TBankAppTheme

@Preview
@Composable
fun MainScreenPreview() {
    TBankAppTheme {
        MainScreen(innerPadding = PaddingValues(0.dp))
    }
}

@Composable
fun MainScreen(innerPadding: PaddingValues) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = innerPadding.calculateTopPadding(),
            bottom = innerPadding.calculateBottomPadding()
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.BackgroundDark)
            .consumeWindowInsets(innerPadding)
    ) {
        item {
            Box(Modifier.padding(horizontal = 16.dp)) {
                SearchField()
            }
        }
        item {
            Box(Modifier.padding(horizontal = 16.dp)) {
                MainScreenProfile()
            }
        }
        item {
            Box(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                PromoCardRow(Modifier.fillMaxWidth())
            }
        }
    }
}


