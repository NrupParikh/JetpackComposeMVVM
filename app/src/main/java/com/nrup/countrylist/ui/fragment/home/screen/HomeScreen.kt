package com.nrup.countrylist.ui.fragment.home.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.nrup.countrylist.R
import com.nrup.countrylist.domain.model.countrylist.CountryData
import com.nrup.countrylist.domain.model.countrylist.CountryListResponse

@Composable
fun HomeScreen(countryList: CountryListResponse?, onClickToDetailScreen: (Pair<Int,String>) -> Unit = {}) {

    val selectedIndex by remember { mutableStateOf(0) }
    //val onItemClick = { index: Int -> selectedIndex = index }

    val mContext = LocalContext.current

    LazyColumn() {
        items(countryList?.size ?: 0) { index ->
            CountryListItem(
                index = index,
                countryList?.get(index),
                selected = selectedIndex == index,
                onClick = onClickToDetailScreen,
                mContext
            )
            Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp)
        }

    }
}

@Composable
fun CountryListItem(
    index: Int,
    data: CountryData?,
    selected: Boolean,
    onClick: (Pair<Int,String>) -> Unit,
    mContext: Context
) {

    val imagePainter = rememberAsyncImagePainter(
        model = data?.flags?.png,
        error = painterResource(id = R.drawable.ic_launcher_foreground)
    )

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(10.dp),
        border = BorderStroke(
            4.dp,
            (if (selected)  MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.background)
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
                    .fillMaxSize()
                    .clickable {
                        onClick.invoke(Pair(index,data?.alpha2Code.toString()))
                    },
                painter = imagePainter,
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
        }
    }

}