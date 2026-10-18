# Android Accessibility Checklist

Review every important screen and interaction.

- Provide meaningful labels for icon-only buttons and controls.
- Ensure screen-reader users can understand the purpose, state, and result of each control.
- Do not rely on color alone to communicate status.
- Check text contrast and support font scaling.
- Make touch targets large enough and keep controls sufficiently separated.
- Preserve logical focus and traversal order.
- Provide visible focus feedback for keyboard/switch navigation where applicable.
- Announce important dynamic changes accessibly without overwhelming users.
- Ensure dialogs and bottom sheets have sensible focus behavior.
- Test empty, loading, error, disabled, and selected states.
- Add captions or text alternatives for meaningful audio/visual content.
- Test with TalkBack and Android accessibility tools on a real device or emulator.

Do not claim accessibility compliance from code inspection alone; report which checks were actually performed.
