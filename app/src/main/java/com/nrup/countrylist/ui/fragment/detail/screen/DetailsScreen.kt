package com.nrup.countrylist.ui.fragment.detail.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.nrup.countrylist.R
import com.nrup.countrylist.domain.model.countrylist.CountryData

@Composable
fun DetailsScreen(countryData: CountryData?) {

    val imagePainter = rememberAsyncImagePainter(
        model = countryData?.flags?.png,
        error = painterResource(id = R.drawable.ic_launcher_foreground)
    )

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(10.dp),
        border = BorderStroke(
            4.dp,
            Color.Black
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)

        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = imagePainter,
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
        }

        Text(
            text = countryData?.name.toString(),
            modifier = Modifier.padding(10.dp)
        )
    }
}