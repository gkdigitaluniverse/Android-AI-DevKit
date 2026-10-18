# Android Project Review Checklist

## 1. Inventory first
Inspect root/module Gradle files and wrapper; plugins and repositories; AndroidManifest.xml; package/application ID; SDK levels; Activities, Fragments, Composables, XML layouts and navigation; ViewModels, repositories, services, workers, receivers and persistence; permissions, exported components and background services; tests, build variants and assets.

Do not assume Compose, XML, MVVM, or any library is present until confirmed.

## 2. Establish baseline
Build the untouched project if the environment allows. Record the exact command and first meaningful error. Distinguish pre-existing errors from errors introduced by a change. If a baseline build cannot run, state why.

## 3. Plan the change
Identify user-visible behavior, files affected, dependencies/manifest changes, migration risks, permissions/privacy implications, tests, and manual verification.

## 4. Implement incrementally
Make the smallest coherent change. Preserve existing navigation, storage, timers, blocking behavior, and settings unless explicitly asked to change them. Avoid replacing whole files when a focused patch is sufficient. Keep UI, business logic, and data access separated according to the existing architecture.

## 5. Verify and report
Run relevant tests/build tasks where available. Review the diff for unrelated changes, secrets, debug code, and accidental deletions. Report changed files, behavior, commands run, results, and remaining risks.
