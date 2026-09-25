package com.composearsenal.awesomebutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AwesomeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: AwesomeButtonVariant = AwesomeButtonVariant.Primary,
    size: AwesomeButtonSize = AwesomeButtonSize.Medium,
    shape: AwesomeButtonShape = AwesomeButtonShape.Rounded,
    colors: AwesomeButtonColors = AwesomeButtonColors(),
    enabled: Boolean = true,
    loading: Boolean = false,
    loadingText: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    icon: ImageVector? = null,
    contentDescription: String? = null,
    fullWidth: Boolean = false
) {
    val buttonHeight = when (size) {
        AwesomeButtonSize.Small -> AwesomeButtonDefaults.SmallHeight
        AwesomeButtonSize.Medium -> AwesomeButtonDefaults.MediumHeight
        AwesomeButtonSize.Large -> AwesomeButtonDefaults.LargeHeight
    }

    val progressSize = when (size) {
        AwesomeButtonSize.Small -> AwesomeButtonDefaults.SmallProgressSize
        AwesomeButtonSize.Medium -> AwesomeButtonDefaults.MediumProgressSize
        AwesomeButtonSize.Large -> AwesomeButtonDefaults.LargeProgressSize
    }

    val textStyle = when (size) {
        AwesomeButtonSize.Small -> MaterialTheme.typography.labelMedium
        AwesomeButtonSize.Medium -> MaterialTheme.typography.labelLarge
        AwesomeButtonSize.Large -> MaterialTheme.typography.titleMedium
    }

    val buttonShape = when (shape) {
        AwesomeButtonShape.Rounded -> MaterialTheme.shapes.small
        AwesomeButtonShape.Medium -> MaterialTheme.shapes.medium
        AwesomeButtonShape.Pill -> RoundedCornerShape(50)
        AwesomeButtonShape.Square -> RoundedCornerShape(0.dp)
    }

    val buttonModifier = when {
        icon != null && !fullWidth -> {
            modifier.size(buttonHeight)
        }

        fullWidth -> {
            modifier
                .fillMaxWidth()
                .height(buttonHeight)
        }

        else -> {
            modifier.height(buttonHeight)
        }
    }

    Button(
        onClick = onClick,
        enabled = enabled && !loading,
        modifier = buttonModifier,
        shape = buttonShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.containerColor ?: when (variant) {
                AwesomeButtonVariant.Primary ->
                    ButtonDefaults.buttonColors().containerColor

                AwesomeButtonVariant.Secondary ->
                    MaterialTheme.colorScheme.secondary

                AwesomeButtonVariant.Danger ->
                    MaterialTheme.colorScheme.error

                AwesomeButtonVariant.Success ->
                    MaterialTheme.colorScheme.primary
            },
            contentColor = colors.contentColor ?: when (variant) {
                AwesomeButtonVariant.Primary ->
                    MaterialTheme.colorScheme.onPrimary

                AwesomeButtonVariant.Secondary ->
                    MaterialTheme.colorScheme.onSecondary

                AwesomeButtonVariant.Danger ->
                    MaterialTheme.colorScheme.onError

                AwesomeButtonVariant.Success ->
                    MaterialTheme.colorScheme.onPrimary
            }
        )
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(progressSize),
                strokeWidth = AwesomeButtonDefaults.LoadingStrokeWidth
            )

            if (loadingText != null) {
                Spacer(
                    modifier = Modifier.width(
                        AwesomeButtonDefaults.IconSpacing
                    )
                )

                Text(
                    text = loadingText,
                    style = textStyle
                )
            }
        } else if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                modifier = Modifier.size(
                    AwesomeButtonDefaults.IconSize
                )
            )
        } else {
            Row {
                if (leadingIcon != null) {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(
                            AwesomeButtonDefaults.IconSize
                        )
                    )

                    Spacer(
                        modifier = Modifier.width(
                            AwesomeButtonDefaults.IconSpacing
                        )
                    )
                }

                Text(
                    text = text,
                    style = textStyle
                )

                if (trailingIcon != null) {
                    Spacer(
                        modifier = Modifier.width(
                            AwesomeButtonDefaults.IconSpacing
                        )
                    )

                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(
                            AwesomeButtonDefaults.IconSize
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AwesomeButtonPreview() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        AwesomeButton(
            text = "Small",
            onClick = {},
            size = AwesomeButtonSize.Small
        )

        AwesomeButton(
            text = "Medium",
            onClick = {},
            size = AwesomeButtonSize.Medium
        )

        AwesomeButton(
            text = "Large",
            onClick = {},
            size = AwesomeButtonSize.Large
        )

        AwesomeButton(
            text = "Danger",
            onClick = {},
            variant = AwesomeButtonVariant.Danger
        )

        AwesomeButton(
            text = "Success",
            onClick = {},
            variant = AwesomeButtonVariant.Success
        )

        AwesomeButton(
            text = "Processing",
            onClick = {},
            size = AwesomeButtonSize.Large,
            loading = true,
            loadingText = "Processing..."
        )

        AwesomeButton(
            text = "Pay Now",
            onClick = {},
            leadingIcon = Icons.Default.Check
        )

        AwesomeButton(
            text = "Continue",
            onClick = {},
            trailingIcon = Icons.AutoMirrored.Filled.ArrowForward
        )

        AwesomeButton(
            text = "Disabled",
            onClick = {},
            enabled = false
        )

        AwesomeButton(
            text = "Full Width",
            onClick = {},
            fullWidth = true
        )

        AwesomeButton(
            text = "Pay Now",
            onClick = {},
            variant = AwesomeButtonVariant.Primary,
            size = AwesomeButtonSize.Large,
            fullWidth = true,
            leadingIcon = Icons.Default.Check
        )

        AwesomeButton(
            text = "",
            icon = Icons.Default.Check,
            contentDescription = "Confirm",
            size = AwesomeButtonSize.Medium,
            onClick = {}
        )

        AwesomeButton(
            text = "",
            icon = Icons.Default.Check,
            contentDescription = "Confirm",
            variant = AwesomeButtonVariant.Success,
            size = AwesomeButtonSize.Large,
            onClick = {}
        )

        AwesomeButton(
            text = "Rounded",
            onClick = {},
            shape = AwesomeButtonShape.Rounded
        )

        AwesomeButton(
            text = "Pill",
            onClick = {},
            shape = AwesomeButtonShape.Pill
        )

        AwesomeButton(
            text = "Square",
            onClick = {},
            shape = AwesomeButtonShape.Square
        )

        AwesomeButton(
            text = "Custom Colors",
            onClick = {},
            colors = AwesomeButtonColors(
                containerColor = androidx.compose.ui.graphics.Color.Black,
                contentColor = androidx.compose.ui.graphics.Color.White
            )
        )
    }
}