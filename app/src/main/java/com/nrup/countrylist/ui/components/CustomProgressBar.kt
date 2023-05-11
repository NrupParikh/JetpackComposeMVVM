package com.nrup.countrylist.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.nrup.countrylist.ui.theme.CountryListTheme

@Composable
fun CustomProgressBar(
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (loadingCircular) = createRefs()

        CircularProgressIndicator(
            modifier = Modifier
                .constrainAs(loadingCircular) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomProgressBar(){
    CountryListTheme{
        CustomProgressBar()
    }
}