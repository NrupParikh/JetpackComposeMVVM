package com.nrup.countrylist.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.nrup.countrylist.R

@Composable
fun CustomOkCancelDialog(
    message: String,
    hasNegativeButton: Boolean,
    onDismiss: () -> Unit,
    onNegativeClick: () -> Unit,
    onPositiveClick: () -> Unit

) {

    Dialog(onDismissRequest = onDismiss) {

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp),
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = message,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp),
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))


            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (hasNegativeButton) {
                    TextButton(onClick = onNegativeClick) {
                        Text(
                            text = "CANCEL",
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(8.dp),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                TextButton(onClick = onPositiveClick) {
                    Text(
                        text = "OK",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(8.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCustomOkCancelDialog() {
    CustomOkCancelDialog(
        message = "My Message",
        hasNegativeButton = true,
        onDismiss = { },
        onNegativeClick = { },
        onPositiveClick = { })
}
// ======= HOW TO CALL

/*

     var showCustomOkCancelDialogWithResult by remember { mutableStateOf(true) }

      if (showCustomOkCancelDialogWithResult) {
            CustomOkCancelDialog(
                message = stringResource(id = R.string.no_internet_connection),
                hasNegativeButton = false,
                onDismiss = {
                    showCustomOkCancelDialogWithResult = !showCustomOkCancelDialogWithResult
                },
                onNegativeClick = {
                    //showCustomOkCancelDialogWithResult = !showCustomOkCancelDialogWithResult
                },
                onPositiveClick = {
                    showCustomOkCancelDialogWithResult = !showCustomOkCancelDialogWithResult
                }
            )
        }

* */