/**
 * Reference pattern: expose immutable UI state from a ViewModel.
 *
 * Adapt package names, repository API, and error model to the target app.
 * Requires AndroidX Lifecycle ViewModel and kotlinx-coroutines.
 * Pattern informed by official Android samples (links in examples/README.md);
 * this is an original, simplified example, not copied source code.
 */
package example.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface ScreenState<out T> {
    data object Loading : ScreenState<Nothing>
    data class Content<T>(val value: T) : ScreenState<T>
    data object Empty : ScreenState<Nothing>
    data class Error(val message: String) : ScreenState<Nothing>
}

interface ItemsRepository<T> {
    suspend fun loadItems(): List<T>
}

class ItemsViewModel<T>(
    private val repository: ItemsRepository<T>
) : ViewModel() {
    private val _state = MutableStateFlow<ScreenState<List<T>>>(ScreenState.Loading)
    val state: StateFlow<ScreenState<List<T>>> = _state.asStateFlow()

    fun load() {
        viewModelScope.launch {
            _state.value = ScreenState.Loading
            try {
                val items = repository.loadItems()
                _state.value = if (items.isEmpty()) {
                    ScreenState.Empty
                } else {
                    ScreenState.Content(items)
                }
            } catch (cancelled: CancellationException) {
                throw cancelled
            } catch (_: Exception) {
                // Keep technical exception details in logs/diagnostics, not UI text.
                _state.value = ScreenState.Error(
                    "Couldn't load data. Check your connection and try again."
                )
            }
        }
    }
}
