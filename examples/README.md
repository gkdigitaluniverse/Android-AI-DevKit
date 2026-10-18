# Practical Android Code Examples

These examples are small reference snippets for AI-assisted Android development. They are **not a complete Android project** and do not install dependencies or configure Gradle automatically.

## Examples

- `kotlin/ApiResult.kt` — explicit loading-independent result types for repository boundaries.
- `kotlin/SafeRepositoryCall.kt` — maps expected network failures while preserving coroutine cancellation.
- `compose/LoadableContent.kt` — renders loading, success, empty, and error states in Compose.
- `testing/ApiResultTest.kt` — small unit tests for result-state mapping.
- `kotlin/ScreenStateViewModel.kt` — generic repository-backed ViewModel exposing explicit loading/content/empty/error states.
- `compose/ScreenStateContent.kt` — Compose renderer for those states with retry handling.
- `java/RepositoryBoundary.java` — small Java repository boundary/result model.
- `xml/accessible-form-example.xml` — accessible XML form layout starting point.

## How to apply safely

1. Read `AI_INSTRUCTIONS.md` and inspect the target project's Kotlin, Gradle, and UI stack.
2. Reuse the project's existing networking and UI libraries; do not add Retrofit, OkHttp, or another dependency merely because an example mentions networking.
3. Adapt package names and types to the app. Keep provider-specific HTTP status handling in the data layer.
4. Add the needed test dependency only if it is not already present.
5. Run the target project's build and tests. These snippets have not been compiled as part of an Android application in this repository.

## Design notes

- Keep API keys and private credentials out of the APK.
- Do not catch `CancellationException` as an ordinary failure.
- A successful response with no usable items should be represented as an empty state, not a generic error.
- Avoid exposing raw exception messages or stack traces directly to end users.

## Proven upstream examples

Use [`../upstream-solutions/README.md`](../upstream-solutions/README.md) to jump to relevant files in Android Architecture Samples and Now in Android. Their full project files often depend on app-specific models, DI, libraries, and build setup, so adapt the pattern rather than pasting a whole file blindly.

## References

- Kotlin exceptions: https://kotlinlang.org/docs/exceptions.html
- Kotlin coroutines cancellation: https://kotlinlang.org/docs/cancellation-and-timeouts.html
- Compose state: https://developer.android.com/develop/ui/compose/state
- Compose testing: https://developer.android.com/develop/ui/compose/testing
- Android architecture: https://developer.android.com/topic/architecture
