package com.nrup.countrylist.ui.components.bottomnav
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

@Composable
fun MyBottomNavigation(
    navController: NavController,
    bottomNavigationItems: List<BottomNavItem>,
    backStackEntry: State<NavBackStackEntry?>
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        bottomNavigationItems.forEach { item ->
            val selected = item.screen_route == backStackEntry.value?.destination?.route

            NavigationBarItem(selected = selected, onClick = {
                navController.navigate(item.screen_route)
            },
                label = {
                    Text(
                        text = item.title,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${item.title} Icon",
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            )

        }
    }
}