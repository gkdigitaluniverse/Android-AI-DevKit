# API Security Rules

## Credential handling
- Never embed private API keys, client secrets, service-account JSON, signing keys, or database passwords in Android source, resources, assets, or build config shipped in the APK.
- Obfuscation does not make an embedded secret safe.
- Store private credentials on a trusted backend and have the app call that backend.
- Rotate credentials if they are committed publicly or included in a distributed build.
- Restrict public client identifiers according to provider guidance.

## Transport and data
- Use HTTPS and platform certificate validation.
- Never disable certificate validation to “fix” a connection problem.
- Request only permissions and data needed for the feature.
- Do not send personal data to third parties without a clear need and appropriate disclosure.
- Never log authorization headers, API keys, tokens, passwords, or sensitive payloads.
- Treat API responses as untrusted input.

## Android-specific checks
Review manifest permissions and exported components. Android Keystore can protect suitable device-held cryptographic material, but it is not a substitute for server-side API secrets. Do not ship broad cleartext-traffic allowances. Treat deep links, WebViews, and intent inputs as untrusted. Enforce privileged authorization on the server, not just by hiding UI controls.
