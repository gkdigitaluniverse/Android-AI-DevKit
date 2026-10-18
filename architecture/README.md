# Architecture

Choose architecture based on app size and existing structure; do not impose layers merely for appearance.

A common separation is:
- UI: renders state and forwards user actions.
- ViewModel/presentation logic: manages screen state and lifecycle-aware work.
- Domain: optional use cases for substantial business rules.
- Data: repositories and data sources for network, database, and local storage.

Keep dependencies flowing in a clear direction, expose observable UI state, and avoid storing Android UI objects in long-lived domain classes. Reference: https://developer.android.com/topic/architecture
