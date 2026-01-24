package com.example.tbankfakeapp.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tbankfakeapp.R
import com.example.tbankfakeapp.ui.theme.AppColors

sealed class BottomItem(
    val route: String,
    @StringRes val titleRes: Int,
    val iconId: Int,
) {
    object MainScreen : BottomItem(
        route = "main_screen",
        titleRes = R.string.bottom_main_text,
        iconId = R.drawable.icon
    )
    object PaymentsScreen : BottomItem(
        route = "payments_screen",
        titleRes = R.string.bottom_payments_text,
        iconId = R.drawable.icon
    )
    object CityScreen : BottomItem(
        route = "city_screen",
        titleRes = R.string.bottom_city_text,
        iconId = R.drawable.icon
    )
    object ChatScreen : BottomItem(
        route = "chat_screen",
        titleRes = R.string.bottom_chat_text,
        iconId = R.drawable.icon
    )
    object HubScreen : BottomItem(
        route = "hub_screen",
        titleRes = R.string.bottom_hub_text,
        iconId = R.drawable.icon
    )
}

@Composable
fun BottomNavigation(
    navController: NavController,
    onNavigate: (String) -> Unit,
) {
    val listItems = listOf(
        BottomItem.MainScreen,
        BottomItem.PaymentsScreen,
        BottomItem.CityScreen,
        BottomItem.ChatScreen,
        BottomItem.HubScreen,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    NavigationBar(
        contentColor = AppColors.TextPrimary,
        containerColor = AppColors.BackgroundDark,
    ) {
        listItems.forEach { item ->
            val interactionSource = remember { MutableInteractionSource() }

            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                        onNavigate(item.route)
                    }
                },
                modifier = Modifier.indication(interactionSource, null),
                interactionSource = interactionSource,
                icon = { Icon(painter = painterResource(id = item.iconId), contentDescription = stringResource(id = item.titleRes), modifier = Modifier.size(24.dp)) },
                label = { Text(text = stringResource(id = item.titleRes), fontSize = 14.sp) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AppColors.PrimaryBlue,
                    unselectedIconColor = AppColors.TextSecondary,
                    selectedTextColor = AppColors.PrimaryBlue,
                    unselectedTextColor = AppColors.TextSecondary,
                    indicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                )
            )
        }

    }
}