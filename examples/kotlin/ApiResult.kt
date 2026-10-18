/**
 * Minimal result type for a repository boundary.
 *
 * Adapt this to the app's existing error model. This file is a reference snippet,
 * not a drop-in replacement for every project's networking architecture.
 */
sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data object Empty : ApiResult<Nothing>
    data class Failure(
        val kind: FailureKind,
        val userMessage: String
    ) : ApiResult<Nothing>
}

enum class FailureKind {
    NETWORK,
    TIMEOUT,
    UNAUTHORIZED,
    RATE_LIMITED,
    SERVER,
    INVALID_RESPONSE,
    UNKNOWN
}
