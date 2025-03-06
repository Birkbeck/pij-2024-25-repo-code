package pij.day20solution.postcode;

/**
 * Class for deserialised objects from JSON response data for GET calls to
 * https://api.postcodes.io/postcodes/some_postcode
 * for Exercise 1.5. It stores some of the fields only indirectly, via a
 * PostcodeResult object. This is to have a correspondence to the JSON
 * response data.<p>
 *
 * If you want, you can additionally create a separate class, say
 * NicePostcodeResponse, that has the desired five fields called
 * status, postcode, region, latitude, and longitude as its own fields
 * and that reads the contents from a PostcodeResponse (with getters)
 * in its constructor.
 */
public class PostcodeResponse {
    /** HTTP status code. */
    private int status;

    /** The actual payload data. */
    private PostcodeResult result;

    // Ex 1.5, Try 1:
    // put the fields as we would like them (but then Gson does not match
    // the fields of the JSON object to them)
    /*
    private String postcode, region;
    private double latitude, longitude;
    */

    @Override
    public String toString() {
        return "PostcodeResponse{status=" + status + ", result=" + result + "}";

                // Remnants from Try 1. Left here for illustration purposes.
                /*
                ", postcode='" + postcode
                + "', region='" + region
                + '", latitude=" + latitude
                + ", longitude=" + longitude + "}";
                 */
    }
}
