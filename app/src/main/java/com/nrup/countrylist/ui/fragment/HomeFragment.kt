package com.nrup.countrylist.ui.fragment

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nrup.countrylist.R
import com.nrup.countrylist.ui.theme.CountryListTheme
import com.nrup.countrylist.utils.Response
import com.nrup.countrylist.viewmodel.HomeViewModel

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    fun launch() {
        homeViewModel.getCountryList()
    }

    launch()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (val countryResponse = homeViewModel.countryListState.value) {
            is Response.Loading -> {

            }

            is Response.Success -> {
                countryResponse.data
            }

            is Response.Failure -> {

            }
        }

        CountryListUI()
    }
}


@Composable
fun CountryListUI() {

    var selectedIndex by remember { mutableStateOf(0) }
    val onItemClick = { index: Int -> selectedIndex = index }

    val mContext = LocalContext.current

    LazyColumn() {
        items(count = 5) { index ->
            CountryListItem(
                index = index,
                selected = selectedIndex == index,
                onClick = onItemClick,
                mContext
            )
        }

    }
}

@Composable
fun CountryListItem(index: Int, selected: Boolean, onClick: (Int) -> Unit, mContext: Context) {
    Image(
        painterResource(
            id = R.drawable.burger
        ),
        contentDescription = null,
        modifier = Modifier
            .clickable {
                onClick.invoke(index)
                Toast
                    .makeText(mContext, "You clicked at $index", Toast.LENGTH_SHORT)
                    .show()
            }
            .background(if (selected) MaterialTheme.colorScheme.secondary else Color.White)
            .fillMaxWidth()
            .padding(12.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun MyUIPreview() {
    CountryListTheme {
        CountryListUI()
    }
}