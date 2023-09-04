package nextstep.jwp.common;

public enum HttpStatus {
    OK(200),
    NOT_FOUND(404);

    private final int statusCode;

    HttpStatus(final int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
