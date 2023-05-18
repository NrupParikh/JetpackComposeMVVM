package com.nrup.countrylist.utils.shimmer

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush

@Composable
fun genericShimmerEffect(): Brush {

    val appColor = MaterialTheme.colorScheme.primary

    // Gradient Colors
    val shimmerColors = listOf(
        appColor.copy(alpha = 0.6f),
        appColor.copy(alpha = 0.2f), // LIGHTEST COLOR
        appColor.copy(alpha = 0.6f)
    )

    val transition = rememberInfiniteTransition()

    // Actual Animation
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Linear Brush
    return Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )
}