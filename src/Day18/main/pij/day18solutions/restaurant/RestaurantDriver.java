package pij.day18solutions.restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Driver class to model the operation of a restaurant where certain dishes
 * are ordered, prepared asynchronously by the cooks, and then eaten.
 */
public class RestaurantDriver {

    /** Interval in ms in which the Future<Meal> objects are checked. */
    public static final int FUTURE_CHECK_MILLIS = 100;

    /** Number of cooks concurrently making food. */
    public static final int NUMBER_OF_COOKS = 3;


    /**
     * @param args ignored.
     */
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(NUMBER_OF_COOKS);
        List<String> dishes = List.of(
                "Avocado", "Bun", "Chips", "", "Pizza", "Rice", "Spaghetti", "Tomatoes"
        );

        List<Future<Meal>> futures = new ArrayList<>();
        for (String dish : dishes) {
            Future<Meal> future = restaurant.order(dish);
            futures.add(future);
        }

        // regularly check on the futures; when the meal of a future is ready,
        // remove the future from the list and eat the meal. Also deal with
        // the case that something goes wrong in the meal preparation.
        while (! futures.isEmpty()) {
            try {
                Thread.sleep(FUTURE_CHECK_MILLIS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Iterator<Future<Meal>> iter = futures.iterator();
            while (iter.hasNext()) {
                Future<Meal> nextFuture = iter.next();
                if (nextFuture.isDone()) {
                    try {
                        Meal meal = nextFuture.get();
                        System.out.println("Eating " + meal + "!");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        Throwable cause = e.getCause();
                        System.out.println("\nOh dear! Something went wrong with meal preparation:");
                        System.out.println(cause.getMessage());
                    }
                    iter.remove();
                }
            }
        }
        restaurant.shutdown();
    }
}
