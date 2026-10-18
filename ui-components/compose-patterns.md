# Jetpack Compose UI Patterns

Apply only when the project uses Jetpack Compose. For XML/View projects, follow the existing stack unless migration is explicitly requested.

## State and recomposition
- Keep composables focused on rendering and UI events.
- Hoist state when multiple components need to share it.
- Keep business logic in a ViewModel or suitable layer.
- Avoid expensive work directly in a composable body.
- Use stable keys for dynamic list items.
- Use lifecycle-aware Flow/StateFlow collection when supported by the project's dependencies.

## Screen states
Plan loading, content, empty, and error states explicitly. Provide retry actions for recoverable failures.

## Accessibility and consistency
- Add meaningful labels to icon-only actions.
- Ensure usable touch targets and logical screen-reader focus.
- Do not communicate state only through color.
- Check text scaling and contrast.
- Reuse the project's theme and components before adding another UI library.
- Do not assume a dependency exists because an example uses it.
- Previews do not replace device/emulator verification.

## Performance
Use lazy lists for long collections. Keep network/disk work out of composables. Avoid unnecessary state reads in hot UI paths and verify on a representative device.
