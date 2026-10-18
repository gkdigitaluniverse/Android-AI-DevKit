# Android App Security Checklist

## Secrets and storage
- Never commit API secrets, signing keys, passwords, tokens, or production database credentials.
- Do not embed private service credentials in the APK.
- Use platform-provided secure storage for suitable device-held secrets; minimize what is stored locally.
- Do not log secrets or sensitive personal information.

## Network
- Use HTTPS with normal certificate validation.
- Do not install permissive trust managers or disable hostname checks.
- Validate responses and handle malformed content safely.
- Apply least privilege to backend credentials and endpoints.

## Components and permissions
- Request only permissions needed for a clear feature.
- Review exported Activities, Services, BroadcastReceivers, and ContentProviders.
- Validate intents, deep links, file URIs, and externally supplied parameters.
- Protect privileged actions with server-side authorization where relevant.
- Treat AccessibilityService, VPNService, foreground services, and device-admin features as high-impact: explain purpose, request user consent, and comply with platform policies.

## WebView
- Load trusted content only where possible.
- Avoid enabling JavaScript or file access unless required.
- Do not expose JavaScript interfaces to untrusted content.
- Validate navigation and external links.

## Release review
Inspect manifest permissions, cleartext traffic settings, debug flags, exported components, dependency updates, signing configuration, and accidental secrets before release. Use official Android security guidance as the authority for platform-specific requirements.
