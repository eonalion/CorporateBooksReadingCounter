package com.epam.library.util;

/**
 *
 */
public class Response<T> {
    private boolean error;
    private T content;

    public Response() {
    }

    public Response(T content) {
        this.content = content;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
