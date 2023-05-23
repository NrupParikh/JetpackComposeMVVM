package com.nrup.countrylist.ui.fragment.favourite.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nrup.countrylist.ui.theme.CountryListTheme

@Composable
fun FavouriteScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Favourite Screen",
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewFavouriteScreen() {
    CountryListTheme {
        FavouriteScreen()
    }
}