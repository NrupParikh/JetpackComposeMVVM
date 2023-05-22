package com.nrup.countrylist.ui.components

import android.R
import android.view.Gravity
import android.view.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomErrorDialog(onDismiss: () -> Unit) {

    Dialog(onDismissRequest = { onDismiss }) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Red.copy(alpha = 0.5f),
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),

            ) {

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Something went wrong !",
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Image(
                    modifier = Modifier.clickable {

                    },
                    painter = painterResource(R.drawable.ic_menu_close_clear_cancel),
                    contentDescription = null,
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCustomErrorDialog() {
    CustomErrorDialog(
        onDismiss = { },
    )
}