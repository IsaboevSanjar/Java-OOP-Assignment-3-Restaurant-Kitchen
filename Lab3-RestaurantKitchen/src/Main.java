import uz.muu.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        RestaurantKitchen restaurantKitchen = new RestaurantKitchen();

        restaurantKitchen.addWaiters(1, "Jon Snow");
        restaurantKitchen.addWaiters(2, "Tyrion Lannister");
        restaurantKitchen.addWaiters(3, "Daenerys Targaryen");
        restaurantKitchen.addWaiters(4, "Arya Stark");

        restaurantKitchen.addMeal(1, "Plov", 20000);
        restaurantKitchen.addMeal(2, "Lagman", 15000);
        restaurantKitchen.addMeal(3, "Qozonkabob", 35000);

        restaurantKitchen.refillProduct("Meat", 30000, true);
        restaurantKitchen.refillProduct("Oil", 10000, true);
        restaurantKitchen.refillProduct("Potatoes", 50000, true);
        restaurantKitchen.refillProduct("Onion", 20000, true);
        restaurantKitchen.refillProduct("Rice", 25000, true);


        System.out.println(restaurantKitchen.getPrice(1));

        restaurantKitchen.addRecipe(1, "Meat", 1000);
        restaurantKitchen.addRecipe(1, "Oil", 400);
        restaurantKitchen.addRecipe(1, "Onion", 500);
        restaurantKitchen.addRecipe(1, "Rice", 1000);

        restaurantKitchen.addRecipe(2, "Meat", 1200);
        restaurantKitchen.addRecipe(2, "Oil", 500);
        restaurantKitchen.addRecipe(2, "Onion", 600);

        restaurantKitchen.addRecipe(3, "Oil", 11000);

        boolean mealAvailable = restaurantKitchen.availableMeal(1);

        System.out.println(restaurantKitchen.availableProduct("Meat"));

        restaurantKitchen.sell(1, "Jon Snow");
        restaurantKitchen.sell(2, "Tyrion Lannister");
        restaurantKitchen.sell(2, "Tyrion Lannister");
        restaurantKitchen.sell(2, "Daenerys Targaryen");
        restaurantKitchen.sell(1, "Arya Stark");
        restaurantKitchen.sell(3, "Arya Stark");
        System.out.println(restaurantKitchen.availableProduct("Meat"));

        System.out.println(restaurantKitchen.availableProduct("Oil"));

        List<Prepared> sortedSoldMealRecipes = restaurantKitchen.preparedMeal();
        for (Prepared mr :
                sortedSoldMealRecipes) {
            System.out.println(mr);
        }
        List<WaiterSalary> sortedWaiters = restaurantKitchen.waitersSalary();
        for (WaiterSalary ws : sortedWaiters) {
            System.out.println(ws);
        }
        restaurantKitchen.totalMealSoldCost();
        restaurantKitchen.totalRestaurantProfit();


    }


}
