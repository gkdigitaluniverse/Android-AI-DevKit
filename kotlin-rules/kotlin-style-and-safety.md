# Kotlin Style and Safety Rules

## Code style
- Follow the project's existing formatting and naming conventions.
- Use PascalCase for classes/types and camelCase for functions/properties.
- Keep functions focused and names meaningful.
- Prefer immutable val unless mutation is required.
- Avoid deeply nested conditionals when early returns improve clarity.
- Use sealed types/enums for finite states when they improve exhaustiveness.

## Nullability and errors
- Prefer nullable types and safe calls over !!.
- Do not swallow exceptions silently.
- Catch specific exceptions when recovery is possible.
- Validate external input at system boundaries.
- Do not use runBlocking on the main thread.

## Coroutines
- Use structured concurrency and an appropriate scope.
- Keep long-running work off the UI thread.
- Propagate cancellation; do not convert cancellation into a normal error.
- Inject dispatchers in testable code when useful.
- Avoid unmanaged global scopes for screen work.

## Review checklist
Are state changes predictable? Can logic be unit-tested? Are errors recoverable? Is work cancelled when no longer needed? Does the change preserve existing behavior?
