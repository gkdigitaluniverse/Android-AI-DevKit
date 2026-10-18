import org.junit.Assert.assertEquals
import org.junit.Test

class ApiResultTest {
    @Test
    fun success_keepsReturnedData() {
        val result: ApiResult<List<String>> =
            ApiResult.Success(listOf("one", "two"))

        assertEquals(
            ApiResult.Success(listOf("one", "two")),
            result
        )
    }

    @Test
    fun empty_isAnExplicitState() {
        val result: ApiResult<List<String>> = ApiResult.Empty

        assertEquals(ApiResult.Empty, result)
    }

    @Test
    fun failure_keepsSafeUserMessageAndKind() {
        val result = ApiResult.Failure(
            kind = FailureKind.NETWORK,
            userMessage = "Check your connection and try again."
        )

        assertEquals(FailureKind.NETWORK, result.kind)
        assertEquals(
            "Check your connection and try again.",
            result.userMessage
        )
    }
}
