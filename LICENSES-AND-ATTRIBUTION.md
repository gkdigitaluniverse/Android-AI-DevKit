# Licenses and Attribution

This repository is intended to contain original guidance, templates, and examples for Android development.

Before adding material from an external repository or website:
1. Record the source URL and author/organization.
2. Check the exact license and its conditions.
3. Preserve copyright notices and required attribution.
4. Note modifications and keep required license text alongside redistributed code.
5. If the license is missing or unclear, do not copy the code; summarize the idea in original words and link to the source instead.

References are not endorsements. Third-party names and trademarks belong to their respective owners.

## Vendored source files

### Android Compose Samples — original VerticalGrid
- Source file: `upstream-solutions/compose-samples/Jetsnack/Grid.kt`
- Upstream repository: https://github.com/android/compose-samples
- Exact upstream revision: `5f2f2cf1fdfdb6472dd46deb8bcd35cbc9024632`
- Exact upstream path: `Jetsnack/app/src/main/java/com/example/jetsnack/ui/components/Grid.kt`
- License: Apache License 2.0; the complete upstream license is retained at `upstream-solutions/compose-samples/LICENSE`.
- Copyright header preserved; no code changes were made during import.
- Provenance and integration notes: `upstream-solutions/compose-samples/README.md`.

### Android Compose Samples — ConfigurableVerticalGrid adaptation
- Adapted source file: `upstream-solutions/adaptations/compose/ConfigurableVerticalGrid.kt`
- Derived from the same Apache-2.0-licensed upstream file and pinned revision listed above.
- Adds configurable horizontal/vertical spacing and validates columns/spacing inputs; original upstream file remains unchanged alongside it.
- The adaptation includes its own copyright/license header and explicitly records the upstream source and adaptation.
- Integration and verification notes: `upstream-solutions/adaptations/compose/README.md`.
