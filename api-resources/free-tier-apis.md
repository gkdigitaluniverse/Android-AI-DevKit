# Free-Tier API Evaluation

Free-tier terms change frequently. Verify current official documentation before relying on quotas or pricing.

| Field | What to record |
|---|---|
| Signup | Account, email or phone verification required? |
| Authentication | API key, OAuth, service account, or server-side signing? |
| Quota | Requests per minute/day/month and how limits are counted |
| Billing | Payment method required? Can overages be charged? |
| Restrictions | Commercial use, attribution, geography, data-use limits |
| Mobile support | Can requests safely originate from Android? |
| Reliability | SLA, status page, versioning, deprecation policy |
| Privacy | Data sent, stored, shared, and retained |
| Exit plan | Can the provider be replaced or data cached safely? |

## Integration rules
- Plan quota limits and provider-failure handling before implementation.
- Never assume a free tier is permanent.
- Do not put a private key or service-account credential in an APK.
- Respect provider attribution, caching, and redistribution terms.
- Log sanitized error categories, not secrets or sensitive payloads.
- Add usage alerts or a server-side budget guard where supported.

For each API, record its official docs URL, endpoint, auth type, quota-check date, pricing/terms link, privacy concerns, and fallback plan.
