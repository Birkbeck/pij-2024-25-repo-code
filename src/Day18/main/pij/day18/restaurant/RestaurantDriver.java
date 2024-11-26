package pij.day18.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Driver class to model the operation of a restaurant where certain dishes
 * are ordered, prepared asynchronously by the cooks, and then eaten.
 */
public class RestaurantDriver {

    /**
     * @param args ignored.
     */
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(3);
        List<String> dishes = List.of(
                "Avocado", "Bun", "Chips", "", "Pizza", "Rice", "Spaghetti", "Tomatoes"
        );

        List<Future<Meal>> futures = new ArrayList<>();
        for (String dish : dishes) {
            Future<Meal> future = restaurant.order(dish);
            futures.add(future);
        }

        // TODO
        // regularly check on the futures; when the meal of a future is ready,
        // remove the future from the list and eat the meal. Also deal with
        // the case that something goes wrong in the meal preparation.
    }
}
