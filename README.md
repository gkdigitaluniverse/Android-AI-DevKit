# Android-AI-DevKit

A reusable, maintainable reference toolkit for building and improving Android apps with AI assistance. It covers Kotlin, Java, XML layouts, Jetpack Compose, architecture, API integration, security, accessibility, and testing.

## Purpose

Use these original checklists and templates to guide an AI coding assistant across new and existing Android projects. This repository is a reference toolkit, not an Android app or a guarantee that generated code will compile without project-specific verification.

## Repository map

- AI_INSTRUCTIONS.md — workflow and quality requirements for AI-assisted changes.
- design-system/ — design tokens and visual consistency.
- ui-components/ — reusable UI guidance.
- kotlin-rules/ and java-rules/ — language-specific conventions.
- xml-layouts/ — XML/View guidance.
- architecture/ — separation of concerns and app structure.
- logic-rules/ — business logic and edge cases.
- api-resources/ — API discovery and safe integration.
- security/ — client-side security and secret handling.
- accessibility/ — accessible Android UI.
- testing/ — unit, UI, and integration testing.
- templates/ — reusable starter patterns.
- LICENSES-AND-ATTRIBUTION.md — attribution and third-party material policy.

## How to use

1. Give your coding AI the project source and ask it to read AI_INSTRUCTIONS.md first.
2. Ask it to inspect the existing stack and files before proposing changes.
3. Point it to the relevant folders for the task.
4. Ask it to preserve existing behavior, explain dependencies and permissions, and run available tests.
5. Review generated changes and test them on a real device or emulator.

## Principles

- Preserve working code and make small, reviewable changes.
- Use official documentation and check dependency compatibility.
- Never put private API credentials in an Android APK.
- Verify licenses before adapting third-party code.
- Be transparent about assumptions and tests not run.

## Official references

- Material Design 3: https://m3.material.io/
- Android architecture: https://developer.android.com/topic/architecture
- Kotlin conventions: https://kotlinlang.org/docs/coding-conventions.html
- Android security: https://developer.android.com/privacy-and-security/security-tips

See LICENSES-AND-ATTRIBUTION.md before adding external code.
