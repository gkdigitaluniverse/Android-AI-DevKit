import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * A small UI renderer for ApiResult. Keep data loading in a ViewModel or
 * repository; this composable only renders the supplied state.
 */
@Composable
fun <T> LoadableContent(
    result: ApiResult<T>,
    onRetry: () -> Unit,
    content: @Composable (T) -> Unit
) {
    when (result) {
        is ApiResult.Success -> content(result.data)

        ApiResult.Empty -> Text("Nothing to show yet.")

        is ApiResult.Failure -> Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                androidx.compose.ui.unit.dp(8)
            )
        ) {
            Text(result.userMessage)
            Button(onClick = onRetry) {
                Text("Try again")
            }
        }
    }
}
