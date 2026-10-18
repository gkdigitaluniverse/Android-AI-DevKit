# ConfigurableVerticalGrid — Adaptation Notes

## Provenance and license

- **Adapted file:** `ConfigurableVerticalGrid.kt`
- **Upstream repository:** https://github.com/android/compose-samples
- **Upstream source:** `Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Grid.kt`
- **Pinned upstream revision:** `5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632`
- **Upstream license:** Apache License 2.0; the complete license text is retained at [the upstream component license](../../compose-samples/LICENSE).
- **Original source:** [Jetsnack/Grid.kt](../../compose-samples/Jetsnack/Grid.kt), intentionally left unchanged.

The adaptation retains the same round-robin column distribution concept. It is a separate file so the upstream source stays available for comparison.

## Changes from upstream

1. Adds `horizontalSpacing` and `verticalSpacing` parameters, both defaulting to zero.
2. Validates `columns > 0` and rejects negative spacing before measuring content.
3. Accounts for horizontal gaps when calculating item width and vertical gaps when calculating each column's height.
4. Avoids treating an unbounded maximum width as a concrete screen width; if the parent supplies no bounded width, the layout uses the incoming minimum width. A bounded-width parent is recommended for useful results.
5. Uses package `dev.gkgameuniverse.androiddevkit.compose` instead of the sample app's package.

## Example

In an existing Jetpack Compose screen:

```kotlin
import androidx.compose.ui.unit.dp
import dev.gkgameuniverse.androiddevkit.compose.ConfigurableVerticalGrid

ConfigurableVerticalGrid(
    columns = 2,
    horizontalSpacing = 12.dp,
    verticalSpacing = 12.dp,
) {
    // Add composable item content here.
}
```

This is a usage shape, not a complete screen or standalone app.

## Limitations and required checks

- This is a regular custom Layout, not a lazy grid. It composes/measures all children and does not scroll by itself.
- Children are assigned round-robin to columns; this is not a staggered-grid algorithm that dynamically selects the shortest column.
- The parent should normally provide a bounded width.
- Test empty content, one item, fewer items than columns, many items, narrow width, varying child heights, RTL placement, and interaction/accessibility semantics in the target app.
- No Gradle compilation, unit/UI test, lint, APK, or device verification has been run because this repository has no complete Android Gradle project.
