# Step 8 — UI and Design Solutions Catalogue

Reviewed: 2026-10-18.

This catalogue records reusable UI patterns from the pinned official Android Compose Samples source and explains when to use them. These files are source references, not a standalone library module. The consuming app must resolve their theme, Material 3, Compose, and project-specific dependencies before use.

## Imported source components

### 1. VerticalGrid
- Local source: [`Jetsnack/Grid.kt`](compose-samples/Jetsnack/Grid.kt)
- Upstream: [official source at pinned revision](https://github.com/android/compose-samples/blob/5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632/Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Grid.kt)
- Pattern: custom Compose `Layout`, equal-width columns, children assigned round-robin.
- Suitable for: small non-lazy grids where all children can be measured at once.
- Caution: not a lazy scrolling grid or shortest-column masonry layout. See the separate configurable adaptation.

### 2. JetsnackSurface
- Local source: [`JetsnackSurface.kt`](Jetsnack/JetsnackSurface.kt)
- Upstream: [official source at pinned revision](https://github.com/android/compose-samples/blob/5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632/Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Surface.kt)
- Pattern: shared surface wrapper for shape, border, elevation, content color, and dark-theme elevation overlay.
- Suitable for: learning how a design system can centralize surface behavior.
- Caution: directly depends on `JetsnackTheme.colors`; this is not a drop-in replacement for Material 3 `Surface`.

### 3. JetsnackButton
- Local source: [`JetsnackButton.kt`](Jetsnack/JetsnackButton.kt)
- Upstream: [official source at pinned revision](https://github.com/android/compose-samples/blob/5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632/Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Button.kt)
- Pattern: gradient button, enabled/disabled styling, configurable shape/padding, button semantics, interaction source, ripple, and previews for dark mode/large font.
- Suitable for: a custom branded action button after the design tokens are mapped.
- Caution: it calls `JetsnackSurface` and reads multiple `JetsnackTheme.colors` tokens. Both source files and compatible theme tokens are needed to compile unchanged.

## UI design practices extracted from the examples

1. Keep component API inputs explicit: click callback, enabled state, shape, spacing, colors, and content.
2. Give interactive elements semantic roles and meaningful accessibility labels where applicable.
3. Include previews for normal, dark-theme, and enlarged-font conditions.
4. Centralize color/shape/typography tokens in the app's existing design system rather than scattering hard-coded values.
5. Prefer standard Material 3 components when custom behavior is not required; custom wrappers increase maintenance and accessibility responsibilities.
6. Check touch target size, contrast, text scaling, RTL, focus/keyboard behavior, and disabled state in the actual app.
7. Avoid copying the Jetsnack theme wholesale into a small project. Adapt only the component behavior and map tokens to the app's established palette.

## Provenance and license

All vendored source files listed here came from `android/compose-samples` at revision `5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632`, licensed under Apache-2.0. Original copyright/license headers are preserved and the complete upstream license is retained in this directory as `LICENSE`. Exact source paths are recorded in each file's linked upstream URL and this catalogue.

## Verification status

- Upstream source and imports inspected: yes.
- Source files copied without intentional code changes: yes.
- Dependency/theme resolution: not run.
- Gradle compile, lint, Compose previews, UI tests, APK, and device checks: not run; this repository has no complete Android Gradle app project.
