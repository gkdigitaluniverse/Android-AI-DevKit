# Kotlin Rules

- Follow https://kotlinlang.org/docs/coding-conventions.html.
- Prefer immutable values (val) unless mutation is necessary.
- Use null-safe types and avoid non-null assertions unless a documented invariant makes them safe.
- Keep UI, domain logic, and data access separated.
- Use coroutines and structured concurrency for asynchronous work; do not block the main thread.
- Handle cancellation and exceptions intentionally.
- Avoid giant classes, duplicate logic, and unexplained constants.
- Match the Kotlin and Android Gradle Plugin versions already used by the project.
