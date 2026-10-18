# Testing

Use a practical test pyramid:
- Unit tests for business rules, parsing, and ViewModel state transitions.
- UI tests for critical user journeys and accessibility behavior.
- Integration tests for repositories and API contracts.
- Manual checks on a small screen, slow/offline network, and supported Android versions.

Before finishing, run the project's available Gradle tests and build tasks when the environment allows. Report exact commands and results; never claim tests passed if they were not run.
