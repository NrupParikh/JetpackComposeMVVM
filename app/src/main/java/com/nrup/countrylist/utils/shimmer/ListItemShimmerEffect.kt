package com.nrup.countrylist.utils.shimmer

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListItemShimmerEffect() {
    ShimmerListItem(genericShimmerEffect())
}

@Composable
fun ShimmerListItem(brush: Brush) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(brush)
    )

}

@Composable
@Preview(showBackground = true)
fun PreviewShimmerListItemLightTheme() {
    val appColor = MaterialTheme.colorScheme.primary

    ShimmerListItem(
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
fun PreviewShimmerShimmerListItemDarkTheme() {
    val appColor = MaterialTheme.colorScheme.primary

    ShimmerListItem(
        brush = Brush.linearGradient(
            listOf(
                appColor.copy(alpha = 0.6f),
                appColor.copy(alpha = 0.2f), // LIGHTEST COLOR
                appColor.copy(alpha = 0.6f)
            )
        )
    )
}