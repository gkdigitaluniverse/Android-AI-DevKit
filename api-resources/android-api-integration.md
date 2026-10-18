# Android API Integration Patterns

Use the project's existing network stack when one is already configured. This guide does not mean Retrofit, OkHttp, Ktor, or another dependency is automatically installed.

## Recommended separation
- UI: renders state and sends user actions.
- ViewModel/presentation state: exposes loading, content, empty, and error states.
- Repository: owns data-source decisions and maps provider responses to app models.
- Remote data source: performs HTTP calls and parses responses.
- Backend: stores private credentials and performs privileged operations when needed.

## Minimum requirements
- Use HTTPS and execute network work off the main thread.
- Configure appropriate timeouts and support cancellation.
- Check HTTP status codes; a completed request is not automatically a success.
- Parse expected response types and handle malformed or empty bodies.
- Avoid retrying non-idempotent operations unless the API supports idempotency.
- Keep network logic out of Activities and Composables.
- Test success, empty, malformed, unauthorized, rate-limited, and offline responses.

Represent at least Loading, Success(data), Empty, and Error states. Do not show stack traces, secret-bearing URLs, or raw provider dumps to users.

## Dependency rule
Inspect settings.gradle(.kts) and module build.gradle(.kts); confirm Kotlin, Android Gradle Plugin, Gradle, and minSdk compatibility; follow official setup docs; add only required dependencies; then build and report the exact result.
