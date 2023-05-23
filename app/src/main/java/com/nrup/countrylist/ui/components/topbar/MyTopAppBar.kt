package com.nrup.countrylist.ui.components.topbar

import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.nrup.countrylist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.inversePrimary
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {
            IconButton(
                onClick = { },
            ) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = "MenuIcon",
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
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

@Composable
@Preview(showBackground = true)
fun LightPreviewMyTopAppBar() {
    MyTopAppBar()
}