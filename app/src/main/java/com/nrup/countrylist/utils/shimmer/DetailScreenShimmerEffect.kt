package com.nrup.countrylist.utils.shimmer

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreenShimmerEffect() {
    ShimmerDetails(genericShimmerEffect())
}

@Composable
fun ShimmerDetails(brush: Brush) {

    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(brush)
        )

        TableScreen(brush)
    }

}

@Composable
@Preview(showBackground = true)
fun LightPreviewDetailScreenShimmerEffect() {
    val appColor = MaterialTheme.colorScheme.primary

    ShimmerDetails(
        brush = Brush.linearGradient(
            listOf(
                appColor.copy(alpha = 0.6f),
                appColor.copy(alpha = 0.2f), // LIGHTEST COLOR
                appColor.copy(alpha = 0.6f)
            )
        )
    )
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun DarkPreviewDetailScreenShimmerEffect() {
    val appColor = MaterialTheme.colorScheme.primary

    ShimmerDetails(
        brush = Brush.linearGradient(
            listOf(
                appColor.copy(alpha = 0.6f),
                appColor.copy(alpha = 0.2f), // LIGHTEST COLOR
                appColor.copy(alpha = 0.6f)
            )
        )
    )
}


@Composable
fun TableScreen(brush: Brush) {

    val column1Weight = .5f
    val column2Weight = .5f

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Here is the header
        item(1) {
            Row(
                Modifier
                    .background(brush)
                    .height(
                        // Used to set Max height to Row Item.
                        intrinsicSize = IntrinsicSize.Max
                    )
            ) {
                TableCell(
                    text = "",
                    weight = column1Weight,
                    TextAlign.Center,
                    FontWeight.Bold,
                    brush = brush
                )
                TableCell(
                    text = "",
                    weight = column2Weight,
                    TextAlign.Center,
                    FontWeight.Bold,
                    brush = brush
                )
            }
        }

        items(20) {
            //val (key, value) = it
            Row(
                Modifier
                    .background(brush)
                    .fillMaxWidth()
                    .height(
                        // Used to set Max height to Row Item.
                        intrinsicSize = IntrinsicSize.Max
                    )
            ) {
                TableCell(
                    text = "",
                    weight = column1Weight,
                    TextAlign.Start,
                    FontWeight.Bold,
                    brush = brush
                )
                TableCell(
                    text = "",
                    weight = column2Weight,
                    TextAlign.Start,
                    FontWeight.Normal,
                    brush = brush
                )
            }
        }
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float,
    textAlign: TextAlign,
    fontWeight: FontWeight,
    brush: Brush
) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.primary,
        textAlign = textAlign,
        modifier = Modifier
            .weight(weight)
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(brush)
            .fillMaxHeight(),
        fontWeight = fontWeight,
    )
}

@Composable
@Preview(showBackground = true)
fun LightPreviewTableScreen() {
    val appColor = MaterialTheme.colorScheme.primary
    TableScreen(
        brush = Brush.linearGradient(
            listOf(
                appColor.copy(alpha = 0.6f),
                appColor.copy(alpha = 0.2f), // LIGHTEST COLOR
                appColor.copy(alpha = 0.6f)
            )
        )
    )
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun DarkPreviewTableScreen() {
    val appColor = MaterialTheme.colorScheme.primary
    TableScreen(
        brush = Brush.linearGradient(
            listOf(
                appColor.copy(alpha = 0.6f),
                appColor.copy(alpha = 0.2f), // LIGHTEST COLOR
                appColor.copy(alpha = 0.6f)
            )
        )
    )
}