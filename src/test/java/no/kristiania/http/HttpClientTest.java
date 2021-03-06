package no.kristiania.http;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientTest {
    @Test
    void shouldGetResponseCode() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/status/200");
        assertEquals(200, client.getStatusCode());
    }

    @Test
    void shouldGetResponseCode2() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/status/400");
        assertEquals(400, client.getStatusCode());
    }
}
