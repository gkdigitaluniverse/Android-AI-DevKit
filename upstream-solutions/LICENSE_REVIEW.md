# Upstream License & Reuse Review — Step 3

Review date: 2026-10-18  
Target repository: `gkdigitaluniverse/Android-AI-DevKit`

## Decision summary

The shortlisted upstream repositories below publish an Apache License 2.0 text at the repository root. Apache-2.0 generally permits source reuse, modification, and redistribution when its conditions are met. This is a **repository-level preliminary clearance**, not blanket clearance for every file, asset, sample dependency, or third-party component inside those repositories.

Before vendoring a particular file, Step 4 must inspect that file's copyright/license header, nearby notices, the sample/module it belongs to, and any included assets or generated files. If a file has a different or unclear license, do not copy it until resolved.

## Repository review

| Upstream repository | License file checked | Preliminary reuse status | Notes |
|---|---|---|---|
| [android/architecture-samples](https://github.com/android/architecture-samples) | `LICENSE` — Apache License 2.0 | Candidate for selected source files | Check file headers and exact sample/module dependencies before copying. |
| [android/compose-samples](https://github.com/android/compose-samples) | `LICENSE` — Apache License 2.0 | Candidate for selected source files | Prefer small, self-contained UI examples; check sample-specific assets and dependencies. |
| [android/nowinandroid](https://github.com/android/nowinandroid) | `LICENSE` — Apache License 2.0 | Candidate for selected source files | Large modular app; do not treat the whole project as drop-in code. Inspect per-file and module assumptions. |
| [coil-kt/coil](https://github.com/coil-kt/coil) | `LICENSE.txt` — Apache License 2.0 | Candidate for examples; prefer using Coil as a dependency | Do not vendor Coil library implementation just to get image loading. Review the license of any separately sourced sample/assets. |
| [android/sunflower](https://github.com/android/sunflower) | `LICENSE` — Apache License 2.0 | Conditional / historical reference | Repository is archived. Use only for a specific pattern that remains technically relevant; prefer maintained examples. |
| [android/architecture-components-samples](https://github.com/android/architecture-components-samples) | `LICENSE` — Apache License 2.0 | Conditional / historical reference | Repository is archived. Use only when a legacy example provides clear value. |

## Apache-2.0 handling checklist for every vendored item

When copying or adapting a source file, the kit must:

1. Include a copy of the applicable Apache-2.0 license with redistributed source.
2. Retain relevant copyright, patent, trademark, and attribution notices already present in the source.
3. Mark modified files prominently with a notice that changes were made; do not imply the upstream authors wrote the modifications.
4. Carry forward relevant attribution text from an upstream `NOTICE` file if that repository includes one. The root-level `NOTICE` path was not found in the initial checks for the shortlisted Android repositories; this is not proof that no nested/module-level notice or third-party notice exists.
5. Record upstream repository URL, exact source path, upstream revision/commit where practical, license, retrieval date, local changes, and dependencies in the kit's per-file inventory.
6. Check third-party dependencies and assets separately. An upstream repository's top-level license does not automatically relicense bundled dependencies, fonts, images, icons, datasets, or other third-party material.
7. Avoid copying files with unclear ownership, incompatible terms, or no verifiable license.

## Existing copied files in Android-AI-DevKit

The initial audit identified these files as originating from `android/architecture-samples`:

- `TasksViewModel.kt`
- `TasksViewModelTest.kt`

They are within the Apache-2.0 repository's general license scope based on the root license check, but their exact upstream paths, file headers, revision, and dependency assumptions still need to be reconciled during Step 4. Do not assume they compile in the current kit; no Android build or test has been run.

## What this review does not establish

- It is not legal advice.
- It does not guarantee every file in any repository is Apache-2.0.
- It does not verify dependency licenses or compatibility.
- It does not establish that any source file builds in this kit.
- It does not authorize copying assets or code from repositories that were not reviewed here.

## Step 3 outcome

**Proceed with selected-file inspection** for the four maintained P1 candidates, subject to per-file checks. Keep the two archived Android projects as secondary references only. Step 4 should now select concrete source files and map their imports, dependencies, and upstream revisions before any new code is copied.
