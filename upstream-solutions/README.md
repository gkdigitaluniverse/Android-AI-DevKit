# Upstream Android Solutions: Reuse Map

Purpose: use proven Android sample repositories as implementation references instead of inventing architecture from scratch. The files linked below remain the upstream source of truth; copy/adapt only the parts that fit the target app and preserve their license notices if redistributing source.

## High-value official sample repositories

### 1. Android Architecture Samples
- Repository: https://github.com/android/architecture-samples
- License checked: Apache License 2.0 (upstream LICENSE).
- Start here for a conventional app architecture and testing examples.
- ViewModel with screen state, filtering, refresh, and repository use: https://github.com/android/architecture-samples/blob/main/app/src/main/java/com/example/android/architecture/blueprints/todoapp/tasks/TasksViewModel.kt
- ViewModel tests using a fake repository: https://github.com/android/architecture-samples/blob/main/app/src/test/java/com/example/android/architecture/blueprints/todoapp/tasks/TasksViewModelTest.kt
- Repository README / architecture summary: https://github.com/android/architecture-samples/blob/main/README.md

### 2. Now in Android
- Repository: https://github.com/android/nowinandroid
- License checked: Apache License 2.0 (upstream LICENSE).
- Start here for a larger, modern multi-module Compose app. Do not copy its whole architecture into a small app without need.
- Architecture learning journey (UI → ViewModel → use case/repository → data): https://github.com/android/nowinandroid/blob/main/docs/ArchitectureLearningJourney.md
- Example ViewModel exposing StateFlow and using viewModelScope: https://github.com/android/nowinandroid/blob/main/feature/bookmarks/impl/src/main/kotlin/com/google/samples/apps/nowinandroid/feature/bookmarks/impl/BookmarksViewModel.kt
- Compose UI test example: https://github.com/android/nowinandroid/blob/main/core/ui/src/androidTest/kotlin/com/google/samples/apps/nowinandroid/core/ui/NewsResourceCardTest.kt

## Which solution to inspect first

| Problem | Start with | Adaptation warning |
|---|---|---|
| UI updates do not reflect data | ViewModel + StateFlow in Architecture Samples or Now in Android | Do not add Hilt/Flow dependencies without checking the project. |
| Loading/error/empty states are inconsistent | This repo's examples/compose/ScreenStateContent.kt and examples/kotlin/ScreenStateViewModel.kt | These are small reference examples, not a complete feature. |
| Data access is mixed into screen code | Architecture Samples repository + ViewModel pattern | Preserve the app's existing data source and persistence choices. |
| Filtering or business logic is buggy | TasksViewModelTest.kt as a testing pattern | The upstream test imports project-specific fake repositories and dependencies. |
| Compose screen needs UI tests | Now in Android NewsResourceCardTest.kt | Use the test APIs/version already configured in the target project. |
| New app uses XML Views | This repo's examples/xml/accessible-form-example.xml | Replace sample string resources and verify labels, focus, and touch targets. |
| Java app needs separation of concerns | This repo's examples/java/RepositoryBoundary.java | The result type is illustrative; map it to the app's existing error model. |

## What was imported into this DevKit

The new Java, Kotlin, Compose, and XML files in examples/ are original, compact teaching examples inspired by common official Android architecture patterns. The linked upstream Kotlin and test files are references, not copied into this repository. That avoids importing large samples with incompatible package names, dependencies, and unrelated app-specific models.

## Safe reuse checklist

1. Read the upstream file and its surrounding interfaces/tests; a single file may rely on many project-specific types.
2. Check the exact license and any NOTICE file before redistributing source. Apache-2.0 redistribution requires retaining notices and including the license; modified files need a modification notice.
3. Keep the target app's existing stack unless there is a reason to migrate.
4. Run the target project's build and tests. A reference file being present here does not mean it has been compiled in your app.
