# API Error Handling

## Common failure categories
- No connectivity or DNS failure
- Timeout or cancellation
- HTTP 400: invalid request or validation issue
- HTTP 401/403: credentials or permissions
- HTTP 404: resource absent or endpoint changed
- HTTP 409: conflict or duplicate operation
- HTTP 429: rate limit; respect Retry-After when provided
- HTTP 5xx: provider/server failure
- Parsing error: unexpected response shape
- Empty successful response: valid but no data

Provider semantics may differ; follow its official reference.

## Retry policy
- Retry only transient failures.
- Use bounded retries with exponential backoff and jitter when appropriate.
- Respect Retry-After.
- Do not blindly retry authentication, validation, or permission errors.
- Avoid duplicate writes; use idempotency keys if supported.
- Stop retrying when a request is cancelled.

## User experience
Explain the issue in plain language, offer retry when useful, preserve user-entered data, and show cached content when safe. Avoid endless spinners: always reach success, empty, or error state. Keep diagnostics sanitized.
