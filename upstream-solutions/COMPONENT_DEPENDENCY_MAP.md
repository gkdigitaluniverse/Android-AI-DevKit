# Step 4 — Source Component and Dependency Map

Reviewed on 2026-10-18 against the upstream `main` refs listed below. The refs are pinned here so a later import can be traced to a reproducible upstream snapshot. This is a source/dependency inspection only: this step does not add any new upstream implementation files, and no Gradle build or test was run.

## Upstream snapshots inspected

| Repository | Inspected commit | License review |
|---|---|---|
| [android/architecture-samples](https://github.com/android/architecture-samples) | `ee66e1526b84c026615df032c705842b7d2a521f` | Apache-2.0; see `LICENSE_REVIEW.md` |
| [android/compose-samples](https://github.com/android/compose-samples) | `5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632` | Apache-2.0; see `LICENSE_REVIEW.md` |
| [android/nowinandroid](https://github.com/android/nowinandroid) | `a49ed253d75e61a2b6ab80a8da677b57437b08eb` | Apache-2.0; see `LICENSE_REVIEW.md` |

## Candidate A — Architecture Samples task ViewModel and tests

Already present in this DevKit:
- `upstream-solutions/architecture-samples/TasksViewModel.kt`
- `upstream-solutions/architecture-samples/TasksViewModelTest.kt`

Upstream source paths:
- `app/src/main/java/com/example/android/architecture/blueprints/todoapp/tasks/TasksViewModel.kt`
- `app/src/test/java/com/example/android/architecture/blueprints/todoapp/tasks/TasksViewModelTest.kt`

**Dependency assessment — high coupling; valuable as an architecture reference, not a standalone drop-in.**

The ViewModel directly depends on AndroidX Lifecycle (`ViewModel`, `SavedStateHandle` and `viewModelScope`), Kotlin Coroutines/Flow, Hilt annotations and `javax.inject`. It also references app-specific types and resources: `Task`, `TaskRepository`, `TasksFilterType`, `FilteringUiInfo`, result constants, `R.string` values, `Async`, `WhileUiSubscribed`, and helper/filter functions. Those project-specific definitions must be brought along or deliberately replaced before this compiles in another app.

The test is not standalone either. It imports `FakeTaskRepository`, `Task`, `MainCoroutineRule`, app result constants/resources, Truth assertions, JUnit, and `kotlinx-coroutines-test`. Relevant upstream support paths include:
- `app/src/main/java/com/example/android/architecture/blueprints/todoapp/data/Task.kt`
- `app/src/main/java/com/example/android/architecture/blueprints/todoapp/data/TaskRepository.kt`
- `app/src/main/java/com/example/android/architecture/blueprints/todoapp/tasks/TasksFilterType.kt`
- `app/src/main/java/com/example/android/architecture/blueprints/todoapp/util/Async.kt`
- `app/src/main/java/com/example/android/architecture/blueprints/todoapp/util/CoroutinesUtils.kt`
- `shared-test/src/main/java/com/example/android/architecture/blueprints/todoapp/data/FakeTaskRepository.kt`
- `shared-test/src/main/java/com/example/android/architecture/blueprints/todoapp/MainCoroutineRule.kt`

**Decision:** retain these files as an attributed upstream reference. Before claiming the sample is reusable/compilable, inspect and either import the minimal support types or create a separate small, self-contained adaptation with a clear modification notice. Do not silently strip dependencies or rewrite upstream code during the source-copy step.

## Candidate B — Jetsnack custom Compose Grid

Upstream path:
- `Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Grid.kt`

**Dependency assessment — low coupling; recommended first component for the next source-import step.**

The file is a compact custom Compose layout and imports only `androidx.compose.runtime.Composable`, `androidx.compose.ui.Modifier`, and `androidx.compose.ui.layout.Layout`. It does not import Jetsnack resources, app models, theme classes, DI, networking, or persistence. Its target project still needs Jetpack Compose runtime/UI dependencies and a compatible Kotlin/Compose compiler setup. The DevKit currently has no Gradle project to declare or verify those dependencies.

**Decision:** candidate for copying in Step 5, preserving its original Apache-2.0 header and recording its exact upstream path and commit. Keep its upstream package initially; package renaming or API adaptation belongs in a later adaptation step and must be documented.

## Candidate C — Jetsnack button and filter components

Upstream paths:
- `Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Button.kt`
- `Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Filters.kt`

**Dependency assessment — medium coupling.**

`Button.kt` uses standard Compose Foundation/Material 3 APIs, but its preview imports `JetsnackTheme`; the full file must be inspected before choosing whether to bring the theme support along or adapt the preview. `Filters.kt` has more coupling: app model `Filter`, app resource `R`, `FilterSharedElementKey`, theme preview, and an experimental shared-transition API. It should not be treated as a standalone component.

**Decision:** `Button.kt` is a possible later candidate after a complete file-level dependency review. Defer `Filters.kt` until its resources, models, navigation/shared-element integration, and experimental API compatibility are understood.

## Candidate D — Now in Android TopicViewModel and tests

Upstream paths:
- `feature/topic/impl/src/main/kotlin/com/google/samples/apps/nowinandroid/feature/topic/impl/TopicViewModel.kt`
- `feature/topic/impl/src/test/kotlin/com/google/samples/apps/nowinandroid/feature/topic/impl/TopicViewModelTest.kt`

**Dependency assessment — very high coupling; reference-only for now.**

The ViewModel uses Hilt assisted injection, Coroutines/Flow, and several Now in Android modules/interfaces: `TopicsRepository`, `UserDataRepository`, `UserNewsResourceRepository`, `NewsResourceQuery`, `Result/asResult`, and multiple domain model types. The feature module build file also depends on `projects.core.data`, `projects.feature.topic.api`, and test modules. Its tests use multiple test repositories, shared test utilities, kotlinx-datetime, and test libraries. Copying just the ViewModel would create unresolved imports and imply a multi-module architecture that this DevKit does not currently have.

**Decision:** use it to study state production and repository boundaries, but do not vendor it as a purported drop-in component.

## Recommended import order

1. **First:** Jetsnack `Grid.kt` — small, low-coupling real upstream source file.
2. **Next:** review whether to import `Button.kt` with a deliberately chosen theme/preview strategy.
3. **Existing reference:** keep Architecture Samples ViewModel/test, but separately track missing support files and do not label them build-verified.
4. **Reference only for now:** Now in Android `TopicViewModel.kt` and Jetsnack `Filters.kt` because their module/resource/model dependencies are too broad for a clean isolated import.

## Verification status and constraints

- Source files and build scripts were inspected through GitHub at the commits above.
- No Android Studio/Gradle build was executed. This repository currently has no root `settings.gradle(.kts)`, root `build.gradle(.kts)`, Gradle wrapper, or Android app module, so a repository-level compile cannot be claimed.
- Upstream dependency versions are not copied wholesale into this library. For a future target app, use the target app's existing compatible Compose/Lifecycle/Coroutines versions and resolve any API/version mismatch there.
- Each imported source file must retain its copyright/license header. The relevant Apache-2.0 license and source provenance must remain discoverable; any adaptation must state that it was modified.
- This document is a technical dependency assessment, not a legal opinion.
