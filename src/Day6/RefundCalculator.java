/**
 * Provides a method to calculate the refund in pence as a function
 * of the original ticket price and the delay of the train service.
 */
public class RefundCalculator {

    /**
     * Calculates the refund in pence given the original ticket price
     * and the delay.
     *
     * @param priceInPence the original price of the ticket in pence
     * @param delayInMinutes the delay of the train service in minutes
     * @returns the refund awarded in pence
     */
    public static int getRefundInPence(int priceInPence, int delayInMinutes) {
        if (priceInPence <= 0) { // no refund if the customer
            return 0;            // did not pay for the ticket
        }
        int percentage = delayToPercentage(delayInMinutes);
        int refundInPenceTimesHundred = priceInPence * percentage;
        int refundInPence = refundInPenceTimesHundred / 100;
        if (refundInPenceTimesHundred % 100 != 0) {
            // round up, so instead of 123.2 pence, we refund 124 pence
            refundInPence++;
        }
        return refundInPence;
    }

    /**
     * Converts the delay to a percentage of the price.
     *
     * @param delayInMinutes the delay of the train service in minutes
     * @returns the percentage of the ticket price for the refund
     */
    private static int delayToPercentage(int delayInMinutes) {
        if (delayInMinutes < 15) {
            return 0;
        }
        if (delayInMinutes < 30) {
            return 15;
        }
        if (delayInMinutes < 60) {
            return 30;
        }
        return 100;
    }
}
