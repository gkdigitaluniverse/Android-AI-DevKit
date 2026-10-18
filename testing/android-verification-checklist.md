# Android Build and Verification Checklist

## Before building
- Confirm repository root and Gradle wrapper.
- Check JDK/Gradle/Android Gradle Plugin compatibility.
- Confirm Android SDK paths and required SDK components.
- Ensure local-only configuration is not committed.
- Inspect build variants and environment variables.

## Common commands
Run from the project root using the project's wrapper and documented tasks.

~~~bash
./gradlew tasks
./gradlew assembleDebug
./gradlew test
~~~

On Windows use gradlew.bat. On Android/Termux, first confirm the environment supports required Android build tools.

## When a command fails
1. Capture the first meaningful error.
2. Classify it: environment, dependency resolution, source compilation, manifest merge, resources, or tests.
3. Change one cause at a time.
4. Re-run the smallest relevant task, then the required full build.
5. Report what was and was not verified.

## Release safety
Do not publish debug builds as production releases. Never commit keystores, signing passwords, tokens, or private configuration. Verify app ID, version, permissions, target SDK, release variant, and install/upgrade behavior.
