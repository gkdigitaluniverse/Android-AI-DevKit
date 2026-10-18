# Android-AI-DevKit

A reusable reference toolkit for building and improving Android apps with AI assistance. It covers Kotlin, Java, XML layouts, Jetpack Compose, architecture, API integration, security, accessibility, and testing.

## Purpose

Use these original checklists and templates to guide an AI coding assistant across new and existing Android projects. This is a reference toolkit, not an Android app or a guarantee that generated code will compile without project-specific verification.

## Repository map

- [AI_INSTRUCTIONS.md](AI_INSTRUCTIONS.md) — required workflow for AI-assisted changes.
- [design-system/](design-system/) — reusable visual-system guidance.
- [ui-components/](ui-components/) — Compose patterns and component guidance.
- [kotlin-rules/](kotlin-rules/) and [java-rules/](java-rules/) — language-specific style and safety.
- [xml-layouts/](xml-layouts/) — XML/View patterns.
- [architecture/](architecture/) — project inspection and architecture review checklist.
- [logic-rules/](logic-rules/) — business logic and edge cases.
- [api-resources/](api-resources/) — API discovery, integration, security, errors, and testing.
- [security/](security/) — Android security checklist.
- [accessibility/](accessibility/) — accessibility checks.
- [testing/](testing/) — build and verification checklist.
- [testing/api-verification-plan.md](testing/api-verification-plan.md) — API test matrix, execution order, and test-report template.
- [templates/](templates/) — reusable AI coding task prompt.
- [examples/](examples/) — practical Kotlin, Compose, and unit-test reference snippets.
- [LICENSES-AND-ATTRIBUTION.md](LICENSES-AND-ATTRIBUTION.md) — third-party material policy.
- [SOURCE_AUDIT.md](SOURCE_AUDIT.md) — file-by-file content provenance, source links, and direct-copy status.
- [QUALITY_REVIEW.md](QUALITY_REVIEW.md) — Android-wide documentation/safety review, fixes made, and verification limits.
- [GITHUB-ACCESS-AND-SOURCE-REVIEW.md](GITHUB-ACCESS-AND-SOURCE-REVIEW.md) — connected GitHub read/write capability check and official Android sample source review.

## How to use

1. Give your coding AI the project source and ask it to read AI_INSTRUCTIONS.md first.
2. Ask it to inspect the existing stack and files before proposing changes.
3. Point it to the relevant guides for the task.
4. Ask it to preserve existing behavior, explain dependency/manifest changes, and run available tests.
5. Review generated changes and test on a real device or emulator.

## Principles

- Preserve working code and make small, reviewable changes.
- Use official documentation and check dependency compatibility.
- Never put private API credentials in an Android APK.
- Verify licenses before adapting third-party code.
- Be transparent about assumptions and tests not run.
- A written rule does not automatically install a dependency or configure a service.

## Official references

- Material Design 3: https://m3.material.io/
- Android architecture: https://developer.android.com/topic/architecture
- Kotlin conventions: https://kotlinlang.org/docs/coding-conventions.html
- Android security: https://developer.android.com/privacy-and-security/security-tips
- Public API discovery list: https://github.com/public-apis/public-apis

See LICENSES-AND-ATTRIBUTION.md before adding external code.
