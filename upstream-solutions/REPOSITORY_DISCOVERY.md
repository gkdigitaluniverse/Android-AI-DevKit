# Upstream Repository Discovery — Step 2

Date reviewed: 2026-10-18  
Target repository: `gkdigitaluniverse/Android-AI-DevKit`

## Purpose

Find existing, maintained, reusable Android solutions that can save implementation time. This is a discovery shortlist, not approval to copy every file. Step 3 must verify licensing and attribution requirements; Step 4 must inspect candidate files and their dependencies before anything is vendored.

## Shortlist

| Priority | Upstream repository | Observed stars* | License metadata | Status | Potential value |
|---|---|---:|---|---|---|
| P1 | [android/architecture-samples](https://github.com/android/architecture-samples) | 45,876 | Apache-2.0 | Active; main | ViewModel/repository boundaries, UI state, architecture alternatives, tests |
| P1 | [android/compose-samples](https://github.com/android/compose-samples) | 23,523 | Apache-2.0 | Active; main | Compose screens, navigation, theming, UI patterns and previews |
| P1 | [android/nowinandroid](https://github.com/android/nowinandroid) | 21,941 | Apache-2.0 | Active; main | Modular app structure, offline-first patterns, data layer, navigation, testing |
| P1 | [coil-kt/coil](https://github.com/coil-kt/coil) | 11,938 | Apache-2.0 | Active; main | Image loading integration and Compose image examples; prefer documented APIs/dependency use over copying library internals |
| P2 | [android/sunflower](https://github.com/android/sunflower) | 17,746 | Apache-2.0 | Archived | Older educational example for Room, repository, ViewModel and Compose migration; use only where still relevant |
| P3 | [android/architecture-components-samples](https://github.com/android/architecture-components-samples) | 130 | Apache-2.0 | Archived | Historical examples only; prefer maintained official samples unless a specific legacy pattern is needed |

*Star counts are a snapshot from GitHub repository metadata retrieved during this review and may change. Popularity is only a discovery signal, not proof of code quality or compatibility.

## Candidate areas to inspect next

1. **Screen state and ViewModels:** identify complete, testable examples rather than copying isolated snippets.
2. **Navigation and Compose UI:** inspect small, reusable examples with limited dependencies.
3. **Repository and data layer:** inspect offline-first, local-cache and remote-data patterns; record required libraries and minimum SDK/toolchain.
4. **Persistence:** look for maintained Room/DataStore examples with tests.
5. **Networking:** evaluate official or well-maintained examples for HTTP, error handling, serialization and cancellation.
6. **Image loading:** use Coil documentation and small integration examples; do not duplicate the whole library.
7. **Testing:** prioritize unit tests and Compose UI tests that can be adapted without importing an entire sample app.

## Inclusion rules

A source is a candidate only if it:
- solves a real, recurring Android development problem;
- has a clearly identifiable source file, sample module, or reusable pattern;
- has a license that permits the intended reuse and has clear attribution requirements;
- has dependencies and setup requirements that can be documented;
- can be adapted without silently breaking its original assumptions;
- is not copied merely to inflate repository size.

## Exclusion / caution rules

- Do not vendor an entire upstream app just because it is popular.
- Do not copy generated, binary, or unrelated assets unless there is a clear need and permission.
- Treat archived projects as historical references, not default recommendations.
- Prefer referencing a library as a dependency over copying its implementation.
- Keep each copied source's upstream URL, exact path, license, copyright notice, retrieval date, local modifications and dependency notes.
- Do not claim a sample is build-tested until it has actually been built in a compatible project.

## Step 2 outcome

This shortlist identifies promising sources for detailed file-level inspection. It does **not** mean their files have been imported into Android-AI-DevKit yet. License and file-level review comes next, followed by explicit selection of files to bring into the kit.
