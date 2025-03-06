package pij.day20solution.postcode;

/**
 * The fields of this class represent the interesting fields of the result
 * component of JSON response data for GET calls to
 * https://api.postcodes.io/postcodes/some_postcode
 */
public class PostcodeResult {
    private String postcode, region;
    private double latitude, longitude;

    @Override
    public String toString() {
        return "PostcodeResult{" +
                "postcode='" + postcode + '\'' +
                ", region='" + region + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
