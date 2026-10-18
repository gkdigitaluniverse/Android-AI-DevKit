# Security

- Never embed private API keys, service-role keys, passwords, or signing secrets in Android client code.
- Treat every value inside an APK as potentially extractable.
- Use HTTPS and validate server certificates; never add permissive trust-all logic.
- Request only permissions the feature genuinely needs.
- Validate data on the server as well as the client.
- Keep authentication tokens in appropriate secure storage and limit their lifetime and scope.
- Avoid logging tokens, personal data, or sensitive request bodies.
- Review official guidance: https://developer.android.com/privacy-and-security/security-tips
