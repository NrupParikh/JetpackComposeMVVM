package com.nrup.countrylist.ui.fragment.home.screen

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.nrup.countrylist.domain.model.countrylist.CountryListResponse
import com.nrup.countrylist.ui.components.CountryListItem

@Composable
fun HomeScreen(
    countryList: CountryListResponse?,
    onClickToDetailScreen: (Triple<Int, String,String>) -> Unit = {}
) {

    val selectedIndex by remember { mutableStateOf(0) }

    LazyColumn() {
        items(countryList?.size ?: 0) { index ->
            CountryListItem(
                index = index,
                countryList?.get(index),
                selected = selectedIndex == index,
                onClick = onClickToDetailScreen
            )
            Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
        }

    }
}
