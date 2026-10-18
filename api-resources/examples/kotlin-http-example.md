# Kotlin HTTP Example: Open-Meteo Forecast

**Goal:** Demonstrate a small HTTPS JSON request from an Android Kotlin project, with network I/O off the main thread, timeouts, HTTP-status validation, JSON validation, and cleanup.

**Provider terms:** Open-Meteo documents its forecast endpoint at https://open-meteo.com/en/docs and usage/pricing terms at https://open-meteo.com/en/pricing. Its public free API is restricted to non-commercial use under the published conditions. Recheck current terms before shipping an app.

> Verification status: this is a documentation/code example. No live endpoint request, Android build, emulator test, or device test was run for this commit.

## 1. Add the Internet permission

In `AndroidManifest.xml`, add this line inside the `<manifest>` element if it is not already present:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

This permission does not require a runtime permission prompt.

## 2. Kotlin data model and request

This example uses Android's `org.json.JSONObject` and `HttpURLConnection`. It assumes the project already includes a compatible kotlinx-coroutines dependency. Do not add duplicate dependencies without checking the project's version catalog/build files.

```kotlin
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

data class CurrentTemperature(
    val temperatureCelsius: Double
)

suspend fun fetchCurrentTemperature(): CurrentTemperature =
    withContext(Dispatchers.IO) {
        val endpoint =
            "https://api.open-meteo.com/v1/forecast" +
                "?latitude=23.02&longitude=72.57&current=temperature_2m"

        val connection = URL(endpoint).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connectTimeout = 10_000
        connection.readTimeout = 10_000
        connection.setRequestProperty("Accept", "application/json")

        try {
            val status = connection.responseCode
            val responseStream = if (status in 200..299) {
                connection.inputStream
            } else {
                connection.errorStream
            }

            val body = responseStream
                ?.bufferedReader(Charsets.UTF_8)
                ?.use { it.readText() }
                ?: throw IOException("HTTP $status returned no response body")

            if (status !in 200..299) {
                throw IOException("Forecast API returned HTTP $status")
            }

            val root = JSONObject(body)
            val current = root.optJSONObject("current")
                ?: throw IOException("Missing 'current' object in API response")

            if (!current.has("temperature_2m") ||
                current.isNull("temperature_2m")
            ) {
                throw IOException("Missing 'current.temperature_2m' in API response")
            }

            CurrentTemperature(
                temperatureCelsius = current.getDouble("temperature_2m")
            )
        } finally {
            connection.disconnect()
        }
    }
```

## 3. Call it from a ViewModel

Invoke the suspend function from a coroutine scope, not directly on the main thread. Adapt the state updates to the existing app architecture; this is a fragment, not a drop-in complete ViewModel.

```kotlin
viewModelScope.launch {
    try {
        val result = fetchCurrentTemperature()
        // Publish result to the existing UI state.
    } catch (cancelled: CancellationException) {
        throw cancelled // Cancellation is control flow, not a user-facing failure.
    } catch (exception: Exception) {
        // Publish a user-readable error state.
        // Do not show raw stack traces or log secrets/sensitive response data.
    }
}
```

Required imports for that fragment depend on the existing ViewModel implementation, commonly including `androidx.lifecycle.viewModelScope` and `kotlinx.coroutines.launch`.

## 4. Production checklist

- Keep the request in a repository/data layer instead of placing networking logic in a Composable.
- Represent loading, success, empty, offline, and error states explicitly.
- The sample uses `readText()`, which reads the whole response into memory. It is intentionally minimal, **not production-ready** for untrusted or potentially large responses; enforce a response-size limit before shipping.
- Preserve coroutine cancellation: catch and rethrow `CancellationException` before any broader `Exception` handler.
- Consider an established HTTP client (for example, OkHttp/Retrofit) for production apps; first inspect the project's current dependencies.
- Respect the provider's published non-commercial restriction, quotas, privacy policy, and uptime expectations.
- Never embed private API credentials in an APK. Put secrets behind a backend.
- Add unit tests for response parsing and error handling, plus an integration test where appropriate.
- Verify the live endpoint, schema, Android build, and target-device behaviour before release.

## Sources

- Open-Meteo API documentation: https://open-meteo.com/en/docs
- Open-Meteo pricing/usage terms: https://open-meteo.com/en/pricing
- Android networking overview: https://developer.android.com/develop/connectivity/network-ops/connecting
- Kotlin coroutines basics: https://kotlinlang.org/docs/coroutines-basics.html
