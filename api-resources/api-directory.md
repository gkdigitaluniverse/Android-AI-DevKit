# API Discovery Directory

This file points to discovery sources. It does **not** guarantee that every listed API is free, stable, safe, or suitable for production.

| Source | Best use | Checks required |
|---|---|---|
| [Public APIs directory](https://github.com/public-apis/public-apis) | Browse APIs by category and authentication | Check provider docs, license, quotas, privacy, and mobile support |
| [Google APIs Explorer](https://developers.google.com/apis-explorer) | Discover and test Google APIs | Verify OAuth scopes, billing, quota, and Android setup |
| [RapidAPI](https://rapidapi.com/) | Compare third-party API listings | Inspect subscription and provider terms |
| [Postman Public API Network](https://www.postman.com/explore) | Find collections and example requests | Treat collections as examples, not authoritative docs |

## Before selecting an API
Record provider and official docs URL; endpoint; authentication; free-tier quota, rate limits and billing triggers; privacy and retention terms; HTTPS support; response format; license and attribution requirements; date last checked; and whether direct Android calls are allowed.

## Decision rule
Do not select an API based only on a label such as “free” or “no key.” Confirm current provider documentation and test a minimal request. If a credential must remain private, call the provider through a backend you control; an Android APK cannot keep embedded secrets confidential.
