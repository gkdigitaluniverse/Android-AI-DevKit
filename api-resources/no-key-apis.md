# APIs That May Work Without a Key

Authentication rules change. This is an evaluation checklist, not a promise that any endpoint will remain unauthenticated or free. Verify official provider documentation immediately before integration.

## Concrete starting points
See [verified-api-candidates.md](verified-api-candidates.md) for a dated, source-linked snapshot distinguishing Open-Meteo (non-commercial free API), GitHub public metadata (rate-limited), and JSONPlaceholder (mock/testing only). The catalogue records that live endpoint and Android integration tests have not been run. REST Countries is explicitly excluded as a guaranteed no-key API because its current docs require an API key.

## Candidate categories to investigate
- Public datasets and open-data portals
- Public holidays and calendar data
- Country, region, and geographic datasets
- Public package/release metadata
- Provider sandbox or demo endpoints
- Open-source project metadata

## Verification checklist
1. Does the specific endpoint work without a key?
2. Is commercial use allowed?
3. Are there rate limits, IP restrictions, or fair-use rules?
4. Is attribution required?
5. Is the data reliable and current enough?
6. Does it support HTTPS and Android clients?
7. Is the response schema documented?
8. Does the privacy policy permit the intended data flow?

“Public API” does not mean unlimited access; “no key” does not mean no rate limit. A browser demo does not prove production suitability. Use a repository/backend abstraction so the app can replace a provider without rewriting the UI. Provide cached, empty, and error states where appropriate.
