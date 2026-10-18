# Vendored Compose Sample: VerticalGrid

This directory contains one unmodified source file from the official Android Compose Samples repository.

- **Component:** `VerticalGrid`
- **Local source path:** `Jetsnack/Grid.kt`
- **Upstream repository:** https://github.com/android/compose-samples
- **Exact upstream path:** `Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Grid.kt`
- **Upstream revision:** `5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632`
- **Upstream file URL at that revision:** https://github.com/android/compose-samples/blob/5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632/Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Grid.kt
- **Copyright:** 2020 The Android Open Source Project
- **License:** Apache License 2.0; full upstream license is retained in this directory as `LICENSE`.
- **Modification status:** No code modifications made during import.
- **Inspection date:** 2026-10-18.

## What it does

Provides a small custom Compose `Layout` that arranges children in vertical columns of equal width, distributing successive children across columns.

## Direct dependencies

The source imports only:
- `androidx.compose.runtime.Composable`
- `androidx.compose.ui.Modifier`
- `androidx.compose.ui.layout.Layout`

A consuming Android project must already have compatible Jetpack Compose runtime and UI dependencies plus a compatible Kotlin/Compose compiler configuration. This repository currently does not contain a complete Gradle Android app project, so the component has **not** been compiled or runtime-tested here.

## Integration cautions

- Keep the upstream copyright/license header in `Grid.kt`.
- The source defaults to two columns. Pass a positive `columns` value; this upstream implementation does not validate `columns > 0`.
- Layout behavior depends on incoming constraints; test it in the target screen, especially for unbounded width, very narrow layouts, and varying item heights.
- The original package name is preserved. Before copying into an app, choose an appropriate package and document any package/API edits as modifications.
