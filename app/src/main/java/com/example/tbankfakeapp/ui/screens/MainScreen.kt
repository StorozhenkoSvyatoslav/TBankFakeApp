package com.example.tbankfakeapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tbankfakeapp.ui.components.mainscreen.PromoCard
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
    val screenPadding = rememberScreenPadding(innerPadding)

    //var query by rememberSaveable { mutableStateOf("") }

    LazyColumn(
        contentPadding = screenPadding,                      // общий padding экрана
        verticalArrangement = Arrangement.spacedBy(16.dp),    // расстояние МЕЖДУ секциями
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.BackgroundDark)
            .consumeWindowInsets(innerPadding)
    ) {
        item {
            SearchField()
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(start = 0.dp, end = 0.dp), // peek справа
                horizontalArrangement = Arrangement.spacedBy(12.dp)        // расстояние между карточками
            ) {
                items(5) {
                    PromoCard(
                        paintId = com.example.tbankfakeapp.R.drawable.promo_card1,
                        modifier = Modifier
                    )
                }
            }
        }
        items(count = 20) {
            SearchField()
        }
    }
}

@Composable
fun SearchField(

) {
    OutlinedTextField(
        value = "Search",
        onValueChange = { },
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth()
    )
}



//@Composable
//fun SearchField(
//    value: String,
//    onValueChange: (String) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    TextField(
//        value = value,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .fillMaxWidth()
//            .height(48.dp),
//        singleLine = true,
//        shape = RoundedCornerShape(24.dp),
//        placeholder = { Text("Поиск") },
//        leadingIcon = {
//            Icon(
//                painter = painterResource(id = com.example.tbankfakeapp.R.drawable.baseline_search_24),
//                contentDescription = "Search"
//            )
//        },
//        colors = TextFieldDefaults.colors(
//            focusedContainerColor = Color(0xFF2A2A2A),
//            unfocusedContainerColor = Color(0xFF2A2A2A),
//            disabledContainerColor = Color(0xFF2A2A2A),
//
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent,
//            disabledIndicatorColor = Color.Transparent,
//
//            focusedTextColor = Color.White,
//            unfocusedTextColor = Color.White,
//            focusedPlaceholderColor = Color(0xFF9AA0A6),
//            unfocusedPlaceholderColor = Color(0xFF9AA0A6),
//
//            focusedLeadingIconColor = Color(0xFF9AA0A6),
//            unfocusedLeadingIconColor = Color(0xFF9AA0A6),
//            cursorColor = Color.White
//        )
//    )
//}
