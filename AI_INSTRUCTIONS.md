# AI Instructions for Android Projects

Use this repository as a project checklist and reference, not as a substitute for inspecting the actual app.

## Required workflow
1. Inspect the existing project structure, Gradle files, AndroidManifest.xml, package names, navigation, and current UI before editing.
2. Identify the app's language and UI stack: Kotlin, Java, XML Views, Jetpack Compose, or a deliberate mix.
3. Preserve working behavior. Make the smallest coherent change; do not rewrite unrelated files.
4. State which files will change and why before a large change. Avoid deleting or overwriting user work without explicit approval.
5. Use official Android APIs and compatible dependencies. Never claim a library is installed until Gradle configuration confirms it.
6. Handle loading, success, empty, offline, and error states in UI that depends on asynchronous data.
7. Keep secrets out of source code and APKs. Use a trusted backend for private API credentials.
8. Add or update tests where practical, then provide exact build/test steps and disclose anything not verified.

## Output expectations
- Summarize the implementation and list changed files.
- Explain required Gradle dependencies and manifest permissions.
- Flag assumptions, migration risks, and manual steps.
- Do not invent API responses, build results, or runtime verification.
- Follow the project's existing conventions unless they are unsafe or inconsistent.

## Source and attribution
Prefer original implementations and official documentation. Before adapting third-party code, check its license and preserve required copyright, license, and attribution notices. Do not copy entire repositories into this toolkit without checking licensing.
