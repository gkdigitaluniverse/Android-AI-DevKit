# Android Design-System Rules

## Start by inspecting
Find the existing theme, color tokens, typography, spacing, shapes, component styles, and dark-mode strategy before introducing new design values.

## Consistency
- Reuse established design tokens rather than scattering raw colors and dimensions.
- Keep spacing, typography, corner shapes, elevation, and icon style consistent.
- Use semantic names such as primary, surface, error, and on-surface instead of naming colors only by hue.
- Keep interactive states distinct: default, pressed, focused, disabled, selected, loading, and error.
- Avoid using color as the only indicator of meaning.

## Responsive behavior
- Check narrow screens, large screens, text scaling, keyboard visibility, and scrolling.
- Keep primary actions visible and predictable.
- Do not hard-code a single device's dimensions.
- Ensure long localized text does not overlap or clip.

## Component discipline
Before creating a new component, check whether the project already has one that can be reused. Add a new dependency only when its value is clear and compatibility has been checked. Preview/screenshot checks help but do not replace device testing.

## Source
Use official Material Design guidance as a reference: https://m3.material.io/
