package com.nrup.countrylist.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nrup.countrylist.ui.theme.CountryListTheme

@Composable
fun ErrorButton(
    modifier: Modifier,
    text: String = "",
    onClick: () -> Unit = {},
) {
    ConstraintLayout(
        modifier = Modifier
    ) {
        val (buttonText) = createRefs()
        TextButton(
            modifier = Modifier
                .constrainAs(buttonText) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            border = BorderStroke(1.dp, Color.Blue),
            onClick = onClick,
        ) {
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorButtonPreview() {
    CountryListTheme() {
        ErrorButton(text = "Error", modifier = Modifier)
    }
}