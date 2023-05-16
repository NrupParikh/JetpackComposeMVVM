package com.nrup.countrylist.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.nrup.countrylist.R
import com.nrup.countrylist.domain.model.countrylist.CountryData

@Composable
fun CountryListItem(
    index: Int,
    data: CountryData?,
    selected: Boolean,
    onClick: ((Pair<Int, String>) -> Unit)?,
) {

    val imagePainter = rememberAsyncImagePainter(
        model = data?.flags?.png,
        error = painterResource(id = R.drawable.ic_launcher_foreground)
    )

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(10.dp),
        border = BorderStroke(
            4.dp,
            (if (selected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.background)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClick?.invoke(Pair(index, data?.alpha2Code.toString()))
                },
            painter = imagePainter,
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
    }
}