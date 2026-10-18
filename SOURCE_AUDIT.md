# Source Audit and Data Provenance

Audit date: 2026-10-18  
Repository: https://github.com/gkdigitaluniverse/Android-AI-DevKit

## Summary

The guides in this repository are written as original checklists, explanations, and workflow templates. In the files reviewed for this audit, I did not identify a third-party repository file copied verbatim or a code sample transplanted from another repository. No external repository's full file was imported.

Important distinction: the previous content-writing pass did not maintain a sentence-by-sentence research log or record a source URL beside every rule. Therefore, this document records the sources that support the subject matter and identifies where a file is an original synthesis; it does not claim that every sentence was individually verified against each link on the audit date.

The public repository public-apis/public-apis is linked as a discovery directory only. Its README/list of APIs was not copied into api-resources/no-key-apis.md or api-resources/free-tier-apis.md. Those two files contain evaluation criteria and categories, not a verified catalogue of specific providers, endpoints, quotas, or prices.

## File-by-file provenance

| Repository file | What the file contains | Provenance / external source |
|---|---|---|
| README.md | Purpose, repository map, usage steps, general principles | Original project overview. Links users to official Android architecture, Kotlin conventions, Material Design 3, Android security, and the public API discovery directory listed below. |
| AI_INSTRUCTIONS.md | Workflow for an AI coding assistant, review/reporting requirements | Original workflow checklist, informed by Android architecture, testing, and security guidance. No external prompt file was imported. |
| LICENSES-AND-ATTRIBUTION.md | Policy for checking licences and attribution before adapting third-party work | Original repository policy text; not copied from a third-party repository. Use the licence attached to each source if content is later reused. |
| api-resources/README.md | Navigation for API guidance | Original index for this repository's API guides. |
| api-resources/api-directory.md | Places to discover APIs and fields to verify before selecting one | Original directory of discovery links. Public API discovery source: https://github.com/public-apis/public-apis (README.md is linked as a directory, not imported). Other discovery links: https://developers.google.com/apis-explorer, https://rapidapi.com/, https://www.postman.com/explore. These are discovery tools; provider documentation must be checked before integration. |
| api-resources/no-key-apis.md | Categories to investigate and a checklist for unauthenticated endpoints | Original checklist/categories. It contains no named endpoint list and makes no claim that a specific API is currently keyless. No public repository data table was copied. |
| api-resources/free-tier-apis.md | Checklist for quota, billing, restrictions, privacy, reliability, and exit planning | Original evaluation template. It contains no provider-specific pricing or quota values, so there is no pricing dataset to attribute. Verify each provider's current official terms during future API selection. |
| api-resources/android-api-integration.md | UI/ViewModel/repository/remote-source separation, networking and error-state guidance | Original synthesis of common Android architecture and network-integration practices. Reference: https://developer.android.com/topic/architecture and https://developer.android.com/develop. No complete implementation file was copied. |
| api-resources/api-error-handling.md | HTTP/network failure categories, retries, user-facing errors | Original checklist. HTTP status semantics should be confirmed against the relevant API/provider documentation; general HTTP reference: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status. Provider-specific retry behaviour may differ. |
| api-resources/api-security.md | Credential handling, HTTPS, permissions, logging, untrusted inputs | Original security checklist informed by Android's official security guidance: https://developer.android.com/privacy-and-security/security-tips. |
| api-resources/api-testing.md | Unit, integration, and manual API testing checklist | Original checklist informed by Android testing documentation: https://developer.android.com/training/testing and https://developer.android.com/develop/ui/compose/testing. |
| kotlin-rules/kotlin-style-and-safety.md | Kotlin naming, nullability, coroutine and error-handling rules | Original summary/checklist; primary style reference: https://kotlinlang.org/docs/coding-conventions.html. Coroutine-specific guidance: https://kotlinlang.org/docs/coroutines-basics.html. |
| java-rules/java-style-and-safety.md | Java code quality, lifecycle/threading, input and error handling | Original Android-focused checklist. General platform guidance: https://developer.android.com/topic/architecture and https://developer.android.com/privacy-and-security/security-tips. No Java source file was copied. |
| xml-layouts/xml-layout-patterns.md | XML/View layout guidance | Original checklist. Official reference: https://developer.android.com/develop/ui/views/layout/declaring-layout. |
| architecture/android-project-review-checklist.md | Existing-project inspection and architecture review | Original checklist informed by https://developer.android.com/topic/architecture and https://developer.android.com/topic/architecture/recommendations. |
| ui-components/compose-patterns.md | Jetpack Compose component/state/UI patterns | Original checklist. Official references: https://developer.android.com/develop/ui/compose and https://developer.android.com/develop/ui/compose/state. |
| testing/android-verification-checklist.md | Build/test/device verification and honest reporting | Original checklist informed by https://developer.android.com/training/testing and https://developer.android.com/develop/ui/compose/testing. No build or runtime test was performed when this documentation was written. |
| templates/ai-task-template.md | Reusable prompt template for an AI coding task | Original template created for this repository; no external prompt template was imported. |
| security/android-security-checklist.md | Android-specific security review | Original checklist informed by https://developer.android.com/privacy-and-security/security-tips. |
| accessibility/accessibility-checklist.md | Accessibility review for Android UI | Original checklist informed by https://developer.android.com/guide/topics/ui/accessibility and https://developer.android.com/develop/ui/compose/accessibility. |
| design-system/design-system-rules.md | Design tokens, consistency, Material 3 guidance | Original design-system checklist. Reference: https://m3.material.io/ and https://developer.android.com/develop/ui/compose/designsystems/material3. |
| logic-rules/business-logic-rules.md | Business rules, validation, edge cases, state and testability | Original checklist informed by general Android architecture guidance: https://developer.android.com/topic/architecture. It contains no domain-specific dataset. |

| `api-resources/verified-api-candidates.md` | Dated API candidate examples, terms/limits, and exclusions | New documentation snapshot summarizing linked official provider docs; no live endpoint test was performed. Verify current provider terms again before integration. |
| `api-resources/examples/kotlin-http-example.md` | Minimal Kotlin HTTPS request example using Open-Meteo | Original illustrative example written for this toolkit and linked to official Open-Meteo, Android networking, and Kotlin coroutine documentation. It is not a complete production client; response-size limits and project-specific integration remain necessary. |
| `testing/api-verification-plan.md` | API integration test matrix and honest test-report template | Original verification plan. It lists tests to run; it is not evidence that the tests were executed. |
| `examples/README.md` | Index and safe-use notes for local code snippets | Original index for this repository's own snippets. |
| `examples/kotlin/ApiResult.kt` | Minimal result-state type | Original illustrative snippet; not copied from a third-party repository. |
| `examples/kotlin/SafeRepositoryCall.kt` | Transport error mapping while rethrowing coroutine cancellation | Original illustrative snippet; not a drop-in replacement for provider-specific error handling. |
| `examples/compose/LoadableContent.kt` | Compose renderer for loading/result states | Original illustrative snippet. Requires the target project to use compatible Compose and Material 3 dependencies. |
| `examples/testing/ApiResultTest.kt` | Unit tests for result-state mapping | Original illustrative test snippet; it has not been compiled or run as part of an Android project in this repository. |

| `examples/kotlin/ScreenStateViewModel.kt` | Generic ViewModel and repository-boundary screen state example | Original compact synthesis of common Android patterns; official source examples are linked in `upstream-solutions/README.md`. Not compiled in this repo. |
| `examples/compose/ScreenStateContent.kt` | Compose renderer for loading, content, empty, and error states | Original compact example; requires compatible Compose and Material 3 dependencies in the target app. Not compiled in this repo. |
| `examples/xml/accessible-form-example.xml` | XML Views form with label association, email autofill/input type, and minimum touch heights | Original example; sample string resources must be supplied by the target app. Not layout-inflated or accessibility-tested here. |
| `examples/java/RepositoryBoundary.java` | Java repository boundary and explicit result category example | Original illustrative snippet. Not compiled in a target Android project. |
| `upstream-solutions/README.md` | Map of official Android sample files for ViewModel, repository, Compose UI tests, and architecture | Original source map with links to Android Architecture Samples and Now in Android. Their LICENSE files were checked as Apache 2.0; upstream files are linked, not copied into this repo. |

## Public repositories checked for direct file reuse

- public-apis/public-apis: referenced as a place to discover API providers. Its README/list was not copied into the DevKit guides.
- Android Architecture Samples and Now in Android were inspected for architecture, ViewModel, and test patterns. Their relevant files are linked in `upstream-solutions/README.md`; no upstream source file was copied into the DevKit in this pass.

This is a content-level audit of the repository files and their visible references, not a forensic proof of every drafting step. Because the previous batch did not save exact source snapshots, URLs, commit SHAs, or line ranges at the time each paragraph was drafted, it would be inaccurate to claim that a specific line came from a specific external file.

The examples added on 2026-10-18 are original compact teaching implementations informed by the reviewed official samples, not verbatim copies. Exact inspected upstream file URLs and the checked Apache-2.0 licensing status are documented in `upstream-solutions/README.md`.

## How to improve provenance for future additions

For every future external example or API entry, record:
1. Exact source URL and file/page heading.
2. Author or owning organization.
3. Source commit SHA or access date when applicable.
4. Applicable licence and attribution requirements.
5. Whether content is quoted, adapted, or independently summarized.
6. What was changed and why.
7. For API listings: official endpoint docs, authentication, quota/pricing page, terms/privacy page, and date verified.

Do not add a provider to a free or no-key catalogue until its current official documentation and a minimal test request have been checked. Do not copy code when its licence is missing or unclear.
