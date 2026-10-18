/**
 * Original reference example for rendering state supplied by a ViewModel.
 * Collect the ViewModel StateFlow with collectAsStateWithLifecycle() in the
 * screen when lifecycle-runtime-compose is already available in the project.
 */
package example.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> ScreenStateContent(
    state: ScreenState<T>,
    onRetry: () -> Unit,
    emptyMessage: String = "Nothing to show yet.",
    content: @Composable (T) -> Unit
) {
    when (state) {
        ScreenState.Loading -> Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CircularProgressIndicator()
            Text("Loading…")
        }

        is ScreenState.Content -> content(state.value)

        ScreenState.Empty -> Text(emptyMessage)

        is ScreenState.Error -> Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(state.message)
            Button(onClick = onRetry) {
                Text("Try again")
            }
        }
    }
}
