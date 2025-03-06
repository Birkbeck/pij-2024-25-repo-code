package pij.day20solution.postcode;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static java.net.HttpURLConnection.HTTP_OK;
// alternatively, define
//     private static final int HTTP_OK = 200;
// in the present class

/**
 * Client for the REST API offered at
 * <a href="https://catfact.ninja/fact">https://catfact.ninja/fact</a>
 * to issue a GET request and to print the received fact about cats.
 */
public class PostcodeClient {

    /**
     * The minimum time between two HTTP requests to avoid the impression
     * of a denial-of-service attack by too many requests in a short period
     * of time.
     */
    private static final int REQUEST_PAUSE_MILLIS = 1000;

    /**
     * This main method may throw a number of checked exceptions. Here we
     * skip catching these exception for brevity. In a real application,
     * they should of course be checked properly so that the user does not
     * get to see a stack trace, but a proper error message.
     *
     * @param args ignored
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args)
            throws URISyntaxException, IOException, InterruptedException {
        retrieveOnePostcode();
        Thread.sleep(REQUEST_PAUSE_MILLIS); // take a break between requests
        retrieveManyPostcodes();
    }

    // Exercises 1.1 to 1.6
    private static void retrieveOnePostcode()
            throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.postcodes.io/postcodes/WC1E7HX")) // Ex 1.1
                //.uri(new URI("https://api.postcodes.io/postcodes/WC1E 7HX")) // Ex 1.2
                //.uri(new URI("https", "//api.postcodes.io/postcodes/WC1E 7HX", null)) // Ex 1.2
                //.uri(new URI("https", "//api.postcodes.io/postcodes/notAPostcode", null)) // Ex 1.3
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(getRequest, BodyHandlers.ofString());
        int statusCode = response.statusCode();

        // Ex 1.4
        if (statusCode != HTTP_OK) {
            System.out.println("Query unsuccessful with status code: " + statusCode);
            return;
        }
        System.out.println("Query successful!");
        System.out.println(response.body());

        // Ex 1.5
        Gson gson = new Gson();
        PostcodeResponse postcodeResponse = gson.fromJson(response.body(), PostcodeResponse.class);

        System.out.println(postcodeResponse);
    }

    // Exercises 1.7 to 1.9
    public static void retrieveManyPostcodes()
            throws URISyntaxException, IOException, InterruptedException {
        String[] myPostcodes = {"SW1A 0AA", "EH99 1SP", "CF99 1SN", "BT4 3XX", "WC1E 7HX"};
        ManyPostcodesQueryData data = new ManyPostcodesQueryData(myPostcodes);
        Gson gson = new Gson();
        String jsonData = gson.toJson(data);
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https", "//api.postcodes.io/postcodes/", null)) // Ex 1.7
                //.uri(new URI("https", "//api.postcodes.io/postcodes/?filter=postcode,region,longitude,latitude", null)) // Ex 1.9
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(getRequest, BodyHandlers.ofString());
        int statusCode = response.statusCode();
        if (statusCode != HTTP_OK) {
            System.out.println("Query unsuccessful with status code: " + statusCode);
            return;
        }
        System.out.println("Query successful!");
        System.out.println(response.body());

        // Ex 1.8
        ManyPostcodesResponse manyPostcodesResponse =
                gson.fromJson(response.body(), ManyPostcodesResponse.class);

        System.out.println(manyPostcodesResponse);
    }
}