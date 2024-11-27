package pij.day18solutions.restaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * A restaurant has a given number of cooks. The restaurant allows for
 * ordering meals that are prepared asynchronously by the cooks.
 */
public class Restaurant {

    /**
     * The executor service that takes the role of the cooks for our restaurant
     * in meal preparation. Non-null.
     */
    private final ExecutorService cooks;

    /**
     * Initialises a restaurant with a given number of cooks.
     *
     * @param nCooks the number of cooks
     * @throws IllegalArgumentException if nCooks is zero or less
     */
    public Restaurant(int nCooks) {
        this.cooks = Executors.newFixedThreadPool(nCooks);
    }

    /**
     * Orders a meal with the given dish name. Synchronized because the
     * restaurant has only one member of staff at the bar who can take orders.
     *
     * @param dishName the name of the dish
     * @return the ticket for the meal
     * @throws NullPointerException if dishName is the null reference
     */
    public synchronized Future<Meal> order(String dishName) {
        MealOrder order = new MealOrder(dishName);
        Future<Meal> result = this.cooks.submit(order);
        return result;
    }

    /**
     * Shuts down the restaurant for the night. The cooks prepare the
     * remaining orders, and then they go home. After this method is
     * called, no new orders are accepted.
     */
    public void shutdown() {
        this.cooks.shutdown();
    }
}
