# Android XML Layout Patterns

Use this guide when the app uses Android Views and XML layouts. Do not migrate a working XML screen to Compose unless explicitly requested.

## Layout quality
- Prefer existing project components and themes.
- Use ConstraintLayout or another layout already configured when it simplifies responsive positioning; do not add dependencies without checking the project.
- Avoid excessive nested layouts and hard-coded screen dimensions.
- Use string, dimension, color, and style resources for reusable values and localization.
- Provide appropriate content descriptions for meaningful images and icon-only controls.
- Ensure touch targets, text scaling, contrast, and focus order remain usable.

## Resource hygiene
- Use stable, descriptive resource names.
- Avoid duplicate IDs and unused resources.
- Keep user-visible strings out of layout literals when localization is relevant.
- Check light/dark theme behavior if the project supports both.
- Verify layouts on small and large screens and with enlarged font settings.

## Binding and lifecycle
- Follow the project's existing ViewBinding/DataBinding approach.
- Avoid repeated findViewById lookups when the project already uses ViewBinding.
- Do not keep references to destroyed Activities or Views.
- Keep network and business logic out of layout files.

## Verification
Build after resource changes; XML may compile but still produce poor runtime layouts. Test scrolling, keyboard overlap, accessibility, orientation, and empty/error states where relevant.
