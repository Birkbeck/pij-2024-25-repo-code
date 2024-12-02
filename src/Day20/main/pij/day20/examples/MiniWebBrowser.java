package pij.day20.examples;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * This class implements a (very) minimalistic web browser, which sends
 * a GET request to a given URL and prints the message body "as is"
 * on the screen.
 */
public class MiniWebBrowser {
    public static void main(String[] args)
            throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://www.bbk.ac.uk/courses/postgraduate/computer-science"))
//                .uri(new URI("https://catfact.ninja/fact"))
                .GET()
                .build();
        HttpResponse<String> response;
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            response = httpClient.send(getRequest, BodyHandlers.ofString());
        }
        System.out.println(response.body());
    }
}