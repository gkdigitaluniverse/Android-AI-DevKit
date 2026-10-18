# API Testing Checklist

## Unit tests
Test valid and empty responses; missing optional fields; malformed JSON; HTTP 400, 401/403, 404, 429, and 5xx; timeout, offline, and cancellation; retry behavior; and mapping from provider DTOs to app models.

## Integration tests
- Use a sandbox/test environment where available.
- Keep test credentials out of source control.
- Do not make ordinary unit tests depend on a live third-party service.
- Verify request method, path, headers, query parameters, and body.
- Check pagination and rate-limit behavior.
- Ensure errors do not expose secrets or stack traces.

## Manual verification
Record device/emulator and Android version, build variant, reproduction steps, expected vs actual behavior, network availability, and sanitized logs.

Never claim tests passed unless they were actually executed. If execution is unavailable, label the test as not run.
