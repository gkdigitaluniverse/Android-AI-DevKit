# Application Logic

- Convert requirements into explicit inputs, outputs, constraints, and edge cases before coding.
- Keep calculations and business rules testable independently of UI.
- Validate input at system boundaries.
- Handle duplicate taps, retries, timeouts, cancellation, and offline conditions where relevant.
- Do not silently swallow exceptions or report success when an operation failed.
- Use deterministic logic for critical flows and cover boundary conditions with tests.
