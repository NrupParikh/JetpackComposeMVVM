package com.nrup.countrylist.ui.components.bottomnav

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.nrup.countrylist.ui.components.currentRoute

@Composable
fun MyBottomNavigation(
    navController: NavController,
    bottomNavigationItems: List<BottomNavItem>
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        val currentRoute = currentRoute(navController = navController)
        bottomNavigationItems.forEach { item ->
            val selected = item.screen_route == currentRoute
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${item.title} Icon",
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                },
                alwaysShowLabel = true,
                selected = selected,
                onClick = {
                    navController.navigate(item.screen_route) {

                        /*
                            Pop up to the start destination of the graph to
                            avoid building up a large stack of destinations
                            on the back stack as users select items
                        */

                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }

                            /*
                                Avoid multiple copies of the same destination when
                                re-selecting the same item
                            */

                            launchSingleTop = true

                            // Restore state when re-selecting a previously selected item
                            restoreState = true
                        }
                    }

                },
            )
        }
    }
}