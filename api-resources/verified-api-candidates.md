# API Candidate Catalogue — Verified Documentation Snapshot

**Checked on:** 2026-10-18  
**Purpose:** Give Android developers concrete starting points while distinguishing production APIs from mock/demo services. This is a documentation review, not a guarantee of uptime. The endpoints below were checked against the linked provider documentation; no live HTTP request or Android integration test was performed for this catalogue.

## Candidates

| API / service | Example endpoint | Authentication | Published limits / terms | Appropriate use | Status |
|---|---|---|---|---|---|
| Open-Meteo Forecast API | `https://api.open-meteo.com/v1/forecast?latitude=23.02&longitude=72.57&current=temperature_2m` | No key for the public free API | Official pricing page says the free API is for **non-commercial use**, rate-limited to **10,000 calls/day**, and has no uptime guarantee. Commercial use requires the applicable customer plan/licence. | Learning, prototypes, and eligible non-commercial apps | Candidate only; confirm terms and endpoint behaviour before release |
| GitHub REST API — public repository metadata | `https://api.github.com/repos/octocat/Hello-World` | Public data can be requested without authentication | Official docs state the unauthenticated primary limit is **60 requests/hour**, associated with the originating IP. Authenticated requests have different limits. Some endpoints have stricter limits. | Public repository information, release metadata, developer tools | Candidate; handle rate-limit headers and 403/429 responses |
| JSONPlaceholder | `https://jsonplaceholder.typicode.com/posts/1` | No key for the documented demo endpoint | The service describes itself as a fake/mock REST API for development and testing. It is not a source of real production data and should not be treated as persistent storage. | UI prototypes, Retrofit/HTTP learning, test fixtures | **Demo/testing only**, not a production data dependency |

## Important exclusions and cautions

- **REST Countries:** Do not list it as a guaranteed no-key API. Its current documentation says the API endpoints require an API key; the documentation demo key is for trying the docs and is not a general production credential. See the [official docs](https://restcountries.com/docs).
- A public endpoint is not automatically suitable for commercial use, high traffic, or direct calls from every Android app.
- Never ship private API credentials in an APK. If a provider credential must remain secret, use a backend.
- Provider terms, quotas, and endpoints can change. Recheck the official docs on the date of integration and record the result.

## Official sources

1. Open-Meteo API docs: https://open-meteo.com/en/docs
2. Open-Meteo pricing and usage terms: https://open-meteo.com/en/pricing
3. GitHub REST API rate limits: https://docs.github.com/en/rest/using-the-rest-api/rate-limits-for-the-rest-api
4. JSONPlaceholder guide/source: https://github.com/typicode/jsonplaceholder
5. REST Countries docs: https://restcountries.com/docs

## Verification record

- Documentation sources reviewed: the official provider documentation linked above.
- Live endpoint smoke tests: **not run**.
- Android client integration/build test: **not run**.
- Licence/terms conclusion: only the use restrictions explicitly stated above are recorded; check the provider's current terms/privacy policy before shipping.
- Next update should add a dated smoke-test result (HTTP status, response content type, schema check) without recording secrets or personal data.
