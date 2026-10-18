import kotlinx.coroutines.CancellationException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Illustrative wrapper around a suspend network operation.
 *
 * Map provider-specific HTTP status codes in the API/data source layer. This
 * helper only classifies common transport exceptions and deliberately rethrows
 * coroutine cancellation.
 */
suspend fun <T> safeRepositoryCall(
    request: suspend () -> T
): ApiResult<T> {
    return try {
        val value = request()
        ApiResult.Success(value)
    } catch (cancelled: CancellationException) {
        throw cancelled
    } catch (timeout: SocketTimeoutException) {
        ApiResult.Failure(
            kind = FailureKind.TIMEOUT,
            userMessage = "The request took too long. Please try again."
        )
    } catch (network: IOException) {
        ApiResult.Failure(
            kind = FailureKind.NETWORK,
            userMessage = "Couldn't connect. Check your connection and try again."
        )
    } catch (error: Exception) {
        // Log a sanitized diagnostic through the app's approved logger.
        // Never expose raw exception details or secrets to the UI.
        ApiResult.Failure(
            kind = FailureKind.UNKNOWN,
            userMessage = "Something went wrong. Please try again."
        )
    }
}
