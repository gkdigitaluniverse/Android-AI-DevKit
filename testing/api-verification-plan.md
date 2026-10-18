# API Verification Plan for Android Projects

This plan is a reusable procedure for verifying an API integration without pretending a checklist is an executed test report. Adapt it to the actual project's Gradle setup, HTTP client, and architecture.

## Current example under review

- Example: [Kotlin HTTP example](../api-resources/examples/kotlin-http-example.md)
- Provider: Open-Meteo Forecast API
- Expected request: HTTPS GET to `/v1/forecast` with latitude, longitude, and `current=temperature_2m` query parameters
- Expected response fields used by the example: `current.temperature_2m`
- Expected failures to handle: timeout/network failure, non-2xx status, malformed JSON, missing `current`, missing/null temperature
- Provider restriction: check current terms; the public free API is documented for non-commercial use
- Status for this repository: **test plan added; API request, Android build, and device/emulator tests not run**

## Test matrix

| Test | Setup | Expected result | Execution status |
|---|---|---|---|
| Successful response | Valid JSON with numeric `current.temperature_2m` | Parsed temperature returned | Not run |
| Missing current object | JSON without `current` | Clear parse error | Not run |
| Missing temperature | `current` object without `temperature_2m` | Clear parse error | Not run |
| Malformed JSON | Invalid JSON response body | Parsing error, no app crash | Not run |
| HTTP 400/401/403/404 | Server returns non-2xx status | Error path; do not parse as success | Not run |
| HTTP 429 | Rate-limit response | Error surfaced; avoid immediate retry loops | Not run |
| HTTP 5xx | Provider/server failure | Error surfaced; retry only under bounded policy | Not run |
| Timeout/offline | No connection or slow response | Failure state, UI remains responsive | Not run |
| Coroutine cancellation | Cancel caller while request is pending | Cancellation should not be silently swallowed | Not run |
| Large/unexpected response | Return unexpectedly large body | Client should enforce a bounded response strategy before production | Not run |
| Device build | Build using the project's Gradle wrapper | Build succeeds with compatible JDK/SDK/dependencies | Not run |

## Recommended execution order

1. Inspect the actual app's Gradle files, version catalog, manifest, min SDK, and existing networking libraries.
2. Extract response parsing into a small function that accepts JSON and returns a model. Unit-test this function without network access.
3. If using OkHttp, consider MockWebServer for deterministic HTTP status, body, delay, and disconnect tests. Add it only through the project's existing dependency/version conventions.
4. Test successful and malformed responses first.
5. Test HTTP errors, timeout, cancellation, and rate-limit handling.
6. Run the relevant unit-test task, then the debug build.
7. Smoke-test the live provider separately; record date, HTTP status, content type, schema checks, and whether the test used a real device or emulator.
8. Record results honestly. Never mark a test as passed merely because test instructions or sample code exist.

## Safe reporting template

Copy and fill in only after actually running the checks:

- Date/time:
- Commit:
- Environment (OS, JDK, Gradle, Android SDK):
- Command:
- Result: PASS / FAIL / NOT RUN
- First meaningful error (if any):
- Test device/emulator and Android version:
- Live endpoint smoke test: PASS / FAIL / NOT RUN
- Notes (no secrets, tokens, personal data, or full sensitive payloads):

## Release gate

Do not describe the integration as production-ready until provider terms have been checked, credentials and privacy have been reviewed, error/loading states exist, automated tests have run, and a build plus target-device test has passed.
