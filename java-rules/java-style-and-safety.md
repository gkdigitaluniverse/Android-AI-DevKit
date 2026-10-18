# Java Android Style and Safety Rules

Apply these rules only to Java files; preserve the project's existing language and conventions.

## Code quality
- Use clear class and method names and keep methods focused.
- Prefer private fields and the narrowest practical visibility.
- Use constants for repeated values that represent configuration or domain meaning.
- Avoid mutable global state and unexplained numeric/string literals.
- Keep UI code separate from data access and business rules where practical.
- Do not convert a Kotlin project to Java or vice versa without explicit need.

## Lifecycle and threading
- Never perform blocking network or disk work on the main thread.
- Tie asynchronous work to an appropriate lifecycle or managed executor.
- Handle cancellation and avoid updating destroyed screens.
- Do not create unmanaged threads for routine screen work.

## Errors and input
- Validate external input at boundaries.
- Catch exceptions only when the code can recover or add useful context.
- Do not silently ignore failures.
- Avoid exposing stack traces or internal server details in user-facing UI.
- Treat network responses, intents, deep links, and WebView content as untrusted.

## Review
Check null handling, resource cleanup, lifecycle behavior, testability, accessibility, and whether the change preserves existing behavior.
