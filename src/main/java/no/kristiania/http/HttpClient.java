package no.kristiania.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HttpClient {
    private final int statusCode;

    public HttpClient(String host, int port, String requestTarget) throws IOException {
        Socket socket = new Socket(host, port);
        socket.getOutputStream().write(("GET " + requestTarget + " HTTP/1.1\r\nHost: " + host + "\r\n\r\n").getBytes());

        String[] statusLine = readLine(socket.getInputStream()).split(" ");
        statusCode = Integer.parseInt(statusLine[1]);
    }

    private String readLine(InputStream in) throws IOException {
        StringBuilder result = new StringBuilder();
        int c;
        while ((c = in.read()) != -1 && c != '\r') {
            result.append((char)c);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("httpbin.org", 80);
        socket.getOutputStream().write("GET /html HTTP/1.1\r\nHost: httpbin.org\r\n\r\n".getBytes());

        InputStream in = socket.getInputStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
    }
    public int getStatusCode() {
        return statusCode;
    }
}
