package com.composearsenal.showcase

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

@Composable
fun LibraryListScreen(
    onLibraryClick: (LibraryItem) -> Unit
) {
    var searchQuery by remember {
        mutableStateOf("")
    }

    val filteredLibraries = composeArsenalLibraries.filter { library ->
        library.name.contains(searchQuery, ignoreCase = true) ||
                library.category.contains(searchQuery, ignoreCase = true) ||
                library.description.contains(searchQuery, ignoreCase = true)
    }

    val groupedLibraries = filteredLibraries.groupBy {
        it.category
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 32.dp,
                bottom = 16.dp
            )
    ) {

        // App Title
        Text(
            text = "Compose Arsenal",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        // Subtitle
        Text(
            text = "Jetpack Compose Libraries",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(
                alpha = 0.7f
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 2.dp,
                    bottom = 20.dp
                ),
            textAlign = TextAlign.Center
        )

        // Search
        OutlinedTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Search libraries",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            searchQuery = ""
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear search",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(18.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(
                    alpha = 0.5f
                ),
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface
            )
        )

        // Library List
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            if (groupedLibraries.isEmpty()) {
                item {
                    Text(
                        text = "No libraries found",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            groupedLibraries.forEach { (category, libraries) ->

                item {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(
                            top = 8.dp,
                            bottom = 2.dp
                        )
                    )
                }

                items(libraries) { library ->
                    LibraryCard(
                        library = library,
                        onClick = {
                            onLibraryClick(library)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun LibraryCard(
    library: LibraryItem,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Card(
        onClick = onClick,
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
            modifier = Modifier.padding(18.dp)
        ) {

            // Library Name
            Text(
                text = library.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Category
            Text(
                text = library.category,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = 6.dp)
            )

            // Description
            Text(
                text = library.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 8.dp)
            )

            // Version
            Text(
                text = "Version ${library.version}",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 12.dp)
            )

            // GitHub Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(
                    onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(library.githubUrl)
                        )
                        context.startActivity(intent)
                    }
                ) {
                    Text(
                        text = "GitHub",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}