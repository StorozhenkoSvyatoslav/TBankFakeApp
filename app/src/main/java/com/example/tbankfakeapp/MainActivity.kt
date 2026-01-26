package com.example.tbankfakeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.tbankfakeapp.ui.components.BottomNavigation
import com.example.tbankfakeapp.ui.screens.ChatScreen
import com.example.tbankfakeapp.ui.screens.CityScreen
import com.example.tbankfakeapp.ui.screens.MainScreen
import com.example.tbankfakeapp.ui.screens.PaymentsScreen
import com.example.tbankfakeapp.ui.screens.HubScreen
import com.example.tbankfakeapp.ui.theme.TBankAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TBankAppTheme {

                val itemsCount = 5
                val pagerState = rememberPagerState(pageCount = { itemsCount })
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigation(
                            currentPage = pagerState.currentPage,
                            onNavigateToPage = { page ->
                                scope.launch { pagerState.animateScrollToPage(page) }
                            }
                        )
                    }
                ) { innerPadding: PaddingValues ->

                    HorizontalPager(
                        state = pagerState,
                        userScrollEnabled = false,
                        modifier = Modifier.fillMaxSize()
                    ) { page ->
                        when (page) {
                            0 -> MainScreen(innerPadding)
                            1 -> PaymentsScreen(innerPadding)
                            2 -> CityScreen(innerPadding)
                            3 -> ChatScreen(innerPadding)
                            4 -> HubScreen(innerPadding)
                        }
                    }
                }
            }
        }
    }
}