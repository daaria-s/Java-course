package edu.hw4;

import java.util.Objects;

public class ValidationError extends Error {

    final String error;

    public ValidationError(String err) {
        this.error = err;
    }

    public String getError() {
        return error;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ValidationError that = (ValidationError) o;
        return Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error);
    }
}
