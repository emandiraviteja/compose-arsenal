package com.composearsenal.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.composearsenal.awesomebutton.AwesomeButton
import com.composearsenal.awesomebutton.AwesomeButtonColors
import com.composearsenal.awesomebutton.AwesomeButtonShape
import com.composearsenal.awesomebutton.AwesomeButtonSize
import com.composearsenal.awesomebutton.AwesomeButtonVariant
import kotlinx.coroutines.delay

@Composable
fun AwesomeButtonShowcaseScreen(
    onBack: () -> Unit
) {
    var isLoading by remember {
        mutableStateOf(false)
    }

    var selectedVariant by remember {
        mutableStateOf(AwesomeButtonVariant.Primary)
    }

    var selectedSize by remember {
        mutableStateOf(AwesomeButtonSize.Medium)
    }

    var selectedShape by remember {
        mutableStateOf(AwesomeButtonShape.Rounded)
    }

    var selectedColor by remember {
        mutableStateOf("Default")
    }

    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(2000)
            isLoading = false
        }
    }

    val customColors = when (selectedColor) {
        "Black" -> AwesomeButtonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )

        "Blue" -> AwesomeButtonColors(
            containerColor = Color(0xFF1565C0),
            contentColor = Color.White
        )

        "Purple" -> AwesomeButtonColors(
            containerColor = Color(0xFF6A1B9A),
            contentColor = Color.White
        )

        "Green" -> AwesomeButtonColors(
            containerColor = Color(0xFF2E7D32),
            contentColor = Color.White
        )

        else -> AwesomeButtonColors()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 32.dp,
                bottom = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Header
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Text(
                text = "Awesome Button",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Text(
            text = "Material 3 button component with variants, sizes, icons, loading states and more.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f)
        )

        // Variants
        ShowcaseSectionTitle(
            text = "VARIANTS"
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedVariant == AwesomeButtonVariant.Primary,
                onClick = {
                    selectedVariant = AwesomeButtonVariant.Primary
                },
                label = {
                    Text("Primary")
                }
            )

            FilterChip(
                selected = selectedVariant == AwesomeButtonVariant.Secondary,
                onClick = {
                    selectedVariant = AwesomeButtonVariant.Secondary
                },
                label = {
                    Text("Secondary")
                }
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedVariant == AwesomeButtonVariant.Danger,
                onClick = {
                    selectedVariant = AwesomeButtonVariant.Danger
                },
                label = {
                    Text("Danger")
                }
            )

            FilterChip(
                selected = selectedVariant == AwesomeButtonVariant.Success,
                onClick = {
                    selectedVariant = AwesomeButtonVariant.Success
                },
                label = {
                    Text("Success")
                }
            )
        }

        ShowcasePreviewCard {
            AwesomeButton(
                text = selectedVariant.name,
                onClick = {},
                variant = selectedVariant
            )
        }

        // Sizes
        ShowcaseSectionTitle(
            text = "SIZES"
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedSize == AwesomeButtonSize.Small,
                onClick = {
                    selectedSize = AwesomeButtonSize.Small
                },
                label = {
                    Text("Small")
                }
            )

            FilterChip(
                selected = selectedSize == AwesomeButtonSize.Medium,
                onClick = {
                    selectedSize = AwesomeButtonSize.Medium
                },
                label = {
                    Text("Medium")
                }
            )

            FilterChip(
                selected = selectedSize == AwesomeButtonSize.Large,
                onClick = {
                    selectedSize = AwesomeButtonSize.Large
                },
                label = {
                    Text("Large")
                }
            )
        }

        ShowcasePreviewCard {
            AwesomeButton(
                text = selectedSize.name,
                onClick = {},
                size = selectedSize
            )
        }

        // States
        ShowcaseSectionTitle(
            text = "STATES"
        )

        ShowcasePreviewCard {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AwesomeButton(
                    text = "Pay Now",
                    onClick = {
                        isLoading = true
                    },
                    loading = isLoading,
                    loadingText = "Processing..."
                )

                AwesomeButton(
                    text = "Disabled",
                    onClick = {},
                    enabled = false
                )
            }
        }

        // Icons
        ShowcaseSectionTitle(
            text = "ICONS"
        )

        ShowcasePreviewCard {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AwesomeButton(
                    text = "Continue",
                    onClick = {},
                    trailingIcon = Icons.AutoMirrored.Filled.ArrowForward
                )

                AwesomeButton(
                    text = "Confirm",
                    onClick = {},
                    leadingIcon = Icons.Default.Check
                )

                AwesomeButton(
                    text = "Confirm",
                    icon = Icons.Default.Check,
                    contentDescription = "Confirm",
                    onClick = {}
                )
            }
        }

        // Shapes
        ShowcaseSectionTitle(
            text = "SHAPES"
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedShape == AwesomeButtonShape.Rounded,
                onClick = {
                    selectedShape = AwesomeButtonShape.Rounded
                },
                label = {
                    Text("Rounded")
                }
            )

            FilterChip(
                selected = selectedShape == AwesomeButtonShape.Medium,
                onClick = {
                    selectedShape = AwesomeButtonShape.Medium
                },
                label = {
                    Text("Medium")
                }
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedShape == AwesomeButtonShape.Pill,
                onClick = {
                    selectedShape = AwesomeButtonShape.Pill
                },
                label = {
                    Text("Pill")
                }
            )

            FilterChip(
                selected = selectedShape == AwesomeButtonShape.Square,
                onClick = {
                    selectedShape = AwesomeButtonShape.Square
                },
                label = {
                    Text("Square")
                }
            )
        }

        ShowcasePreviewCard {
            AwesomeButton(
                text = selectedShape.name,
                onClick = {},
                shape = selectedShape
            )
        }

        // Custom Colors
        ShowcaseSectionTitle(
            text = "CUSTOM COLORS"
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedColor == "Default",
                onClick = {
                    selectedColor = "Default"
                },
                label = {
                    Text("Default")
                }
            )

            FilterChip(
                selected = selectedColor == "Black",
                onClick = {
                    selectedColor = "Black"
                },
                label = {
                    Text("Black")
                }
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedColor == "Blue",
                onClick = {
                    selectedColor = "Blue"
                },
                label = {
                    Text("Blue")
                }
            )

            FilterChip(
                selected = selectedColor == "Purple",
                onClick = {
                    selectedColor = "Purple"
                },
                label = {
                    Text("Purple")
                }
            )

            FilterChip(
                selected = selectedColor == "Green",
                onClick = {
                    selectedColor = "Green"
                },
                label = {
                    Text("Green")
                }
            )
        }

        ShowcasePreviewCard {
            AwesomeButton(
                text = selectedColor,
                onClick = {},
                colors = customColors
            )
        }

        // Layout
        ShowcaseSectionTitle(
            text = "LAYOUT"
        )

        ShowcasePreviewCard {
            AwesomeButton(
                text = "Full Width",
                onClick = {},
                fullWidth = true
            )
        }

        // Live Playground
        Text(
            text = "LIVE PLAYGROUND",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Combine the available options and preview the button configuration.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        ShowcaseSectionTitle(
            text = "VARIANT"
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedVariant == AwesomeButtonVariant.Primary,
                onClick = {
                    selectedVariant = AwesomeButtonVariant.Primary
                },
                label = {
                    Text("Primary")
                }
            )

            FilterChip(
                selected = selectedVariant == AwesomeButtonVariant.Secondary,
                onClick = {
                    selectedVariant = AwesomeButtonVariant.Secondary
                },
                label = {
                    Text("Secondary")
                }
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedVariant == AwesomeButtonVariant.Danger,
                onClick = {
                    selectedVariant = AwesomeButtonVariant.Danger
                },
                label = {
                    Text("Danger")
                }
            )

            FilterChip(
                selected = selectedVariant == AwesomeButtonVariant.Success,
                onClick = {
                    selectedVariant = AwesomeButtonVariant.Success
                },
                label = {
                    Text("Success")
                }
            )
        }

        ShowcaseSectionTitle(
            text = "SIZE"
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedSize == AwesomeButtonSize.Small,
                onClick = {
                    selectedSize = AwesomeButtonSize.Small
                },
                label = {
                    Text("Small")
                }
            )

            FilterChip(
                selected = selectedSize == AwesomeButtonSize.Medium,
                onClick = {
                    selectedSize = AwesomeButtonSize.Medium
                },
                label = {
                    Text("Medium")
                }
            )

            FilterChip(
                selected = selectedSize == AwesomeButtonSize.Large,
                onClick = {
                    selectedSize = AwesomeButtonSize.Large
                },
                label = {
                    Text("Large")
                }
            )
        }

        ShowcaseSectionTitle(
            text = "SHAPE"
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedShape == AwesomeButtonShape.Rounded,
                onClick = {
                    selectedShape = AwesomeButtonShape.Rounded
                },
                label = {
                    Text("Rounded")
                }
            )

            FilterChip(
                selected = selectedShape == AwesomeButtonShape.Medium,
                onClick = {
                    selectedShape = AwesomeButtonShape.Medium
                },
                label = {
                    Text("Medium")
                }
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedShape == AwesomeButtonShape.Pill,
                onClick = {
                    selectedShape = AwesomeButtonShape.Pill
                },
                label = {
                    Text("Pill")
                }
            )

            FilterChip(
                selected = selectedShape == AwesomeButtonShape.Square,
                onClick = {
                    selectedShape = AwesomeButtonShape.Square
                },
                label = {
                    Text("Square")
                }
            )
        }

        ShowcaseSectionTitle(
            text = "COLOR"
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedColor == "Default",
                onClick = {
                    selectedColor = "Default"
                },
                label = {
                    Text("Default")
                }
            )

            FilterChip(
                selected = selectedColor == "Black",
                onClick = {
                    selectedColor = "Black"
                },
                label = {
                    Text("Black")
                }
            )

            FilterChip(
                selected = selectedColor == "Blue",
                onClick = {
                    selectedColor = "Blue"
                },
                label = {
                    Text("Blue")
                }
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedColor == "Purple",
                onClick = {
                    selectedColor = "Purple"
                },
                label = {
                    Text("Purple")
                }
            )

            FilterChip(
                selected = selectedColor == "Green",
                onClick = {
                    selectedColor = "Green"
                },
                label = {
                    Text("Green")
                }
            )
        }

        ShowcasePreviewCard {
            AwesomeButton(
                text = selectedVariant.name,
                onClick = {},
                variant = selectedVariant,
                size = selectedSize,
                shape = selectedShape,
                colors = customColors,
                fullWidth = true
            )
        }
    }
}

@Composable
private fun ShowcaseSectionTitle(
    text: String
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun ShowcasePreviewCard(
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            content()
        }
    }
}