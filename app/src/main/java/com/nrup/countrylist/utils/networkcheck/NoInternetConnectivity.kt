package com.nrup.countrylist.utils.networkcheck

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nrup.countrylist.R


@Composable
fun NoInternetConnectivity(
    onRetryClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_no_internet_connection),
                contentDescription = stringResource(id = R.string.app_name),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = "Please, check your Internet connection!",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedButton(
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                onClick = {
                    onRetryClick()
                }
            ) {
                Text(
                    text = "Retry",
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun LightPreviewNoInternetConnectivity() {
    NoInternetConnectivity(onRetryClick = {  })
}

