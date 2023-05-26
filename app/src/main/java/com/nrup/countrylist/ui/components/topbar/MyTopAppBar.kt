package com.nrup.countrylist.ui.components.topbar

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.nrup.countrylist.ui.components.bottomItems
import com.nrup.countrylist.ui.components.currentRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavController, appTitle: MutableState<String>) {

    val previousBackStackEntry = navController.previousBackStackEntry
    val currentRoute = currentRoute(navController = navController)

    // Getting the Title from BottomNavItem based on current route
    val selectedItem = bottomItems.find { it.screen_route == currentRoute }
    TopAppBar(
        title = {
            Text(
                text = selectedItem?.title ?: appTitle.value,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.inversePrimary
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {

            // If current screen is 1st screen of BottomNavigation
            // Ex. Home/Fav/Setting then drawer icon shown or back icon

            if (selectedItem?.title != null) {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Menu,
                        contentDescription = "MenuIcon",
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            } else {
                IconButton(
                    onClick = {
                        navController.navigateUp()
                    },
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "BackIcon",
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            }

        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
    )

}


@SuppressLint("UnrememberedMutableState")
@Composable
@Preview(showBackground = true)
fun LightPreviewMyTopAppBar() {
    MyTopAppBar(
        navController = NavController(LocalContext.current),
        appTitle = mutableStateOf("Title")
    )
}