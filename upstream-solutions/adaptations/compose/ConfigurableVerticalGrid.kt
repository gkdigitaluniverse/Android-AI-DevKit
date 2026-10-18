/*
 * Copyright 2026 The Android-AI-DevKit contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Adapted from Android Open Source Project's Jetsnack VerticalGrid:
 * https://github.com/android/compose-samples/blob/5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632/Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Grid.kt
 * The adaptation adds spacing parameters and validates caller-provided values.
 */

package dev.gkgameuniverse.androiddevkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Arranges composable children into equal-width vertical columns.
 *
 * Children are assigned round-robin to columns, matching the simple upstream
 * VerticalGrid behavior. Unlike a lazy grid, this measures every child and does
 * not provide scrolling; place it inside a suitable scrolling container when needed.
 *
 * The parent should provide a bounded width. [columns] must be positive and
 * spacing values must be non-negative.
 */
@Composable
fun ConfigurableVerticalGrid(
    modifier: Modifier = Modifier,
    columns: Int = 2,
    horizontalSpacing: Dp = 0.dp,
    verticalSpacing: Dp = 0.dp,
    content: @Composable () -> Unit,
) {
    require(columns > 0) { "columns must be greater than zero" }
    require(horizontalSpacing >= 0.dp) { "horizontalSpacing must not be negative" }
    require(verticalSpacing >= 0.dp) { "verticalSpacing must not be negative" }

    Layout(
        content = content,
        modifier = modifier,
    ) { measurables, constraints ->
        val horizontalGap = horizontalSpacing.roundToPx()
        val verticalGap = verticalSpacing.roundToPx()
        val totalGaps = (horizontalGap.toLong() * (columns - 1))
            .coerceAtMost(Int.MAX_VALUE.toLong())
            .toInt()
        val layoutWidth = if (constraints.hasBoundedWidth) constraints.maxWidth else constraints.minWidth
        val availableWidth = (layoutWidth - totalGaps).coerceAtLeast(0)
        val itemWidth = availableWidth / columns
        val itemConstraints = constraints.copy(
            minWidth = itemWidth,
            maxWidth = itemWidth,
            minHeight = 0,
        )
        val placeables = measurables.map { it.measure(itemConstraints) }
        val columnHeights = IntArray(columns)
        val columnItemCounts = IntArray(columns)

        placeables.forEachIndexed { index, placeable ->
            val column = index % columns
            if (columnItemCounts[column] > 0) {
                columnHeights[column] += verticalGap
            }
            columnHeights[column] += placeable.height
            columnItemCounts[column]++
        }

        val contentHeight = (columnHeights.maxOrNull() ?: 0)
            .coerceIn(constraints.minHeight, constraints.maxHeight)

        layout(
            width = layoutWidth,
            height = contentHeight,
        ) {
            val columnY = IntArray(columns)
            val placedCounts = IntArray(columns)

            placeables.forEachIndexed { index, placeable ->
                val column = index % columns
                if (placedCounts[column] > 0) {
                    columnY[column] += verticalGap
                }
                val x = (column.toLong() * (itemWidth.toLong() + horizontalGap.toLong()))
                    .coerceAtMost(Int.MAX_VALUE.toLong())
                    .toInt()
                placeable.placeRelative(x = x, y = columnY[column])
                columnY[column] += placeable.height
                placedCounts[column]++
            }
        }
    }
}
