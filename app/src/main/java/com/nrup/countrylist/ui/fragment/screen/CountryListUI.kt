package com.nrup.countrylist.ui.fragment.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.nrup.countrylist.R
import com.nrup.countrylist.domain.model.CountryListResponse
import com.nrup.countrylist.domain.model.CountryListResponseItem

@Composable
fun CountryListUI(data: CountryListResponse?) {

    var selectedIndex by remember { mutableStateOf(0) }
    val onItemClick = { index: Int -> selectedIndex = index }

    Log.d("TAG", "SIZE ${data?.size ?: 0}")

    val mContext = LocalContext.current

    LazyColumn() {
        items(data?.size ?: 0) { index ->
            CountryListItem(
                index = index,
                data?.get(index),
                selected = selectedIndex == index,
                onClick = onItemClick,
                mContext
            )
            Divider(color = Color.DarkGray, thickness = 1.dp)
        }

    }
}

@Composable
fun CountryListItem(
    index: Int,
    data: CountryListResponseItem?,
    selected: Boolean,
    onClick: (Int) -> Unit,
    mContext: Context
) {
    Log.d("IMAGE at $index", data?.flags?.png ?: "")

    val imagePainter = rememberAsyncImagePainter(
        model = data?.flags?.png,
        error = painterResource(id = R.drawable.ic_launcher_foreground)
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(if (selected) MaterialTheme.colorScheme.secondary else Color.White)
            .padding(8.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onClick.invoke(index)
                    Toast
                        .makeText(mContext, "You have selected ${data?.name}", Toast.LENGTH_SHORT)
                        .show()
                },
            painter = imagePainter,
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
    }

}