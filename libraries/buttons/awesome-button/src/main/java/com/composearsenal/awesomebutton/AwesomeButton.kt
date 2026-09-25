package com.composearsenal.awesomebutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AwesomeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: AwesomeButtonVariant = AwesomeButtonVariant.Primary,
    loading: Boolean = false
) {
    Button(
        onClick = {
            if (!loading) {
                onClick()
            }
        },
        modifier = modifier,
        colors = when (variant) {
            AwesomeButtonVariant.Primary -> ButtonDefaults.buttonColors()

            AwesomeButtonVariant.Secondary -> ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )

            AwesomeButtonVariant.Danger -> ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        }
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(18.dp),
                strokeWidth = 2.dp
            )
        } else {
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AwesomeButtonPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AwesomeButton(
            text = "Primary",
            onClick = {},
            variant = AwesomeButtonVariant.Primary
        )

        AwesomeButton(
            text = "Secondary",
            onClick = {},
            variant = AwesomeButtonVariant.Secondary
        )

        AwesomeButton(
            text = "Delete",
            onClick = {},
            variant = AwesomeButtonVariant.Danger
        )

        AwesomeButton(
            text = "Loading",
            onClick = {},
            variant = AwesomeButtonVariant.Primary,
            loading = true
        )
    }
}