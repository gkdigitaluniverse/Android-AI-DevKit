# Business Logic Rules

- Write down expected behavior and edge cases before changing complex logic.
- Separate domain decisions from UI rendering and network/database plumbing when practical.
- Use explicit state models instead of many unrelated booleans when states are mutually exclusive.
- Validate user input at boundaries and distinguish invalid input from an unavailable service.
- Make timer, billing, access-control, and blocking logic deterministic and testable.
- Use a monotonic clock for elapsed-time calculations when appropriate; do not assume wall-clock time never changes.
- Persist state only when product behavior requires it, and define what happens after process death or device reboot.
- Make repeated actions safe where possible; prevent duplicate submissions for operations that must happen once.
- Define behavior for empty data, offline use, cancellation, permission denial, and partial failure.
- Avoid hidden side effects in UI rendering functions.
- Add tests for normal cases, boundary values, invalid input, and lifecycle/process recreation where relevant.
- Preserve existing user data and working behavior unless the user explicitly approves a change.
