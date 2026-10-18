# AI Instructions for Android Projects

Use this repository as a project checklist and reference, not as a substitute for inspecting the actual app.

## Required workflow

1. Inspect the existing project structure, Gradle files, AndroidManifest.xml, package names, navigation, data flow, and current UI before editing.
2. Identify the actual stack: Kotlin, Java, XML Views, Jetpack Compose, or a deliberate mix. Do not assume a library is installed because a guide mentions it.
3. Establish a baseline build/test result when the environment permits. Separate pre-existing errors from new errors.
4. State which files will change and why before a large change. Avoid deleting or overwriting user work without explicit approval.
5. Preserve working behavior and make the smallest coherent change.
6. Handle loading, success, empty, offline, cancellation, and error states for asynchronous work.
7. Explain required Gradle dependencies, manifest permissions, configuration, migrations, and compatibility risks.
8. Keep private credentials out of source code and APKs. Use a trusted backend for private API credentials.
9. Add/update tests where practical. Report exact commands and results; never claim verification that was not performed.
10. Finish with a concise summary, changed-file list, test/build results, manual checks, and remaining risks.

## Route to relevant guides

- Project inspection: architecture/android-project-review-checklist.md
- Kotlin: kotlin-rules/kotlin-style-and-safety.md
- Java: java-rules/java-style-and-safety.md
- XML Views: xml-layouts/xml-layout-patterns.md
- Compose: ui-components/compose-patterns.md
- Visual consistency: design-system/design-system-rules.md
- Business logic: logic-rules/business-logic-rules.md
- API discovery and integration: api-resources/
- Security: security/android-security-checklist.md and api-resources/api-security.md
- Accessibility: accessibility/accessibility-checklist.md
- Build and verification: testing/android-verification-checklist.md
- Reusable task prompt: templates/ai-task-template.md
- Practical code references: examples/README.md (adapt to the target app; do not assume dependencies are installed).

## Output expectations

- Summarize implementation and list changed files.
- Identify new dependencies and permissions explicitly.
- Flag assumptions, migration risks, and manual steps.
- Do not invent API responses, test results, or build success.
- Follow the project's existing conventions unless they are unsafe or inconsistent.
- A rule file does not install a dependency, create an API key, configure a backend, or grant a permission by itself.

## Source and attribution

Prefer original implementations and official documentation. Before adapting third-party code, check its license and preserve required copyright, license, and attribution notices. Do not copy entire repositories into this toolkit without checking licensing.
