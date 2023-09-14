package org.apache.coyote.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestHeaders {

    private final Map<String, String> headers;

    private RequestHeaders(final Map<String, String> headers) {
        this.headers = headers;
    }

    public static RequestHeaders from(final BufferedReader reader) throws IOException {
        final Map<String, String> headers = new HashMap<>();
        String line = reader.readLine();
        while (!"".equals(line)) {
            final String[] headerParams = line.split(":");
            headers.put(headerParams[0], headerParams[1].trim());
            line = reader.readLine();
        }
        return new RequestHeaders(headers);
    }

    public String getHeaderValue(final String header) {
        return headers.get(header);
    }
}
