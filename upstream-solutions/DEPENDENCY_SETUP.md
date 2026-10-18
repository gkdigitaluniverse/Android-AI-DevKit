# Step 6 — Dependency and Setup Guide

Reviewed: 2026-10-18.

This guide describes the dependencies implied by the source files currently present in `upstream-solutions/`. It deliberately does not pin versions: the DevKit is a source library/reference repository, not a complete Android Gradle project, and dependency versions must be selected to match the consuming app's Android Gradle Plugin, Kotlin, Compose compiler/plugin, minSdk, and existing dependency graph.

## Current status

- There is no root `settings.gradle(.kts)`, root `build.gradle(.kts)`, Gradle wrapper, or Android app module in this repository.
- The vendored Compose `VerticalGrid` source is the first low-coupling, actual upstream component added.
- Architecture Samples `TasksViewModel.kt` and `TasksViewModelTest.kt` are reference files with substantial unresolved app-specific dependencies; they are not a ready-to-build module.
- No build, unit test, lint, APK, or device verification has been performed in this repository.

## Component dependency matrix

| Component | Direct source dependencies | Additional consuming-project requirements | Status |
|---|---|---|---|
| [Jetsnack `Grid.kt`](compose-samples/Jetsnack/Grid.kt) | `androidx.compose.runtime.Composable`, `androidx.compose.ui.Modifier`, `androidx.compose.ui.layout.Layout` | Compatible Compose Runtime and UI artifacts; Kotlin/Compose compiler configuration compatible with the app | Low coupling; not compiled here |
| Architecture Samples `TasksViewModel.kt` | AndroidX Lifecycle ViewModel/SavedStateHandle/viewModelScope; Kotlin Coroutines/Flow; Hilt annotations; `javax.inject.Inject` | Task model/repository, filter types, Async/result types, subscription helper, result constants, Android string resources, Hilt setup/bindings, and repository-specific navigation/state assumptions | Reference only |
| Architecture Samples `TasksViewModelTest.kt` | AndroidX Lifecycle SavedStateHandle; Kotlin Coroutines Test; JUnit; Google Truth | FakeTaskRepository, Task model, MainCoroutineRule, app result constants/resources, plus production ViewModel's full support graph | Not independently runnable |

## Compose VerticalGrid — integration checklist

1. Use an Android module that already has a working Jetpack Compose setup.
2. Ensure the module includes Compose Runtime and Compose UI artifacts using versions compatible with its Kotlin/Compose compiler setup. Do not copy arbitrary versions from another sample into an existing app.
3. Copy `Grid.kt` into a package appropriate for the target app. If changing the package, record that as a modification and retain the copyright/license header.
4. Import `VerticalGrid` from its chosen package and provide a finite, useful width constraint from the parent layout.
5. Pass a positive `columns` count. The upstream implementation does not guard against zero or negative values.
6. Test narrow widths, children of different heights, accessibility/semantics, and scrolling in the actual screen. The component itself does not create a scroll container.
7. Run the target app's normal Gradle compile, lint, and relevant UI tests. Record the exact app commit and results; do not infer compilation from the source being present.

Minimal usage shape (illustrative; requires Compose in the consuming project):

```kotlin
VerticalGrid(columns = 2) {
    // Place composable children here.
}
```

This is an integration example, not a runnable standalone project.

## TasksViewModel — dependencies to resolve before reuse

Before integrating the existing Architecture Samples ViewModel, locate or implement compatible definitions for:
- `Task` and `TaskRepository`
- `TasksFilterType` and any filtering UI state types
- `Async` and `WhileUiSubscribed`
- result constants and `R.string` resources used by the ViewModel
- Hilt module bindings and lifecycle-aware ViewModel setup

For its test, additionally provide:
- `FakeTaskRepository`
- `MainCoroutineRule`
- compatible test dependencies for JUnit, Truth, and `kotlinx-coroutines-test`

Do not simply add dependencies until Gradle resolves: unresolved project classes/resources are architectural requirements, not Maven dependencies. Prefer a small self-contained adaptation only in a later step, with changes explicitly documented and the upstream version retained as provenance.

## Version-selection policy

- First inspect the consuming app's existing version catalog and Gradle plugin versions.
- Prefer versions already used successfully by that app.
- Do not add a second incompatible Compose BOM, Kotlin plugin, Lifecycle, or Coroutines version just to match a sample.
- Hilt requires both compatible library/plugin configuration and application-level setup; annotations alone are insufficient.
- Keep test-only libraries in test configurations rather than production configurations.
- If no consuming app exists yet, defer exact version pinning until a complete Android Gradle sample module is intentionally created.

## License and provenance

See [LICENSES-AND-ATTRIBUTION.md](../LICENSES-AND-ATTRIBUTION.md), [the Compose component notes](compose-samples/README.md), and [the license review](LICENSE_REVIEW.md). Preserve upstream notices and document modifications whenever code is adapted.

## Verification record

- Static import/dependency inspection: completed for the files listed above.
- Dependency resolution: not run.
- Gradle compile/tests/lint: not run.
- APK/device validation: not run.
