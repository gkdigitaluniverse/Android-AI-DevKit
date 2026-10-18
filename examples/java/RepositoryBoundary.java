package example.android;

import java.io.IOException;
import java.util.Objects;

/**
 * Small Java example for keeping data access behind an interface.
 * Adapt exception types and result modeling to the existing app.
 */
public interface RepositoryBoundary<T> {
    Result<T> load();

    final class Result<T> {
        public enum Kind { SUCCESS, EMPTY, NETWORK_ERROR, UNKNOWN_ERROR }

        public final Kind kind;
        public final T value;

        private Result(Kind kind, T value) {
            this.kind = Objects.requireNonNull(kind);
            this.value = value;
        }

        public static <T> Result<T> success(T value) {
            return new Result<>(Kind.SUCCESS, Objects.requireNonNull(value));
        }

        public static <T> Result<T> empty() {
            return new Result<>(Kind.EMPTY, null);
        }

        public static <T> Result<T> networkError() {
            return new Result<>(Kind.NETWORK_ERROR, null);
        }

        public static <T> Result<T> unknownError() {
            return new Result<>(Kind.UNKNOWN_ERROR, null);
        }
    }
}
