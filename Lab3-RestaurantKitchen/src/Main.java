import uz.muu.MealRecipes;
import uz.muu.RestaurantKitchen;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        RestaurantKitchen restaurantKitchen = new RestaurantKitchen();

        restaurantKitchen.addMeal(1, "Plov", 20000);
        restaurantKitchen.addMeal(2, "Lagman", 15000);
        restaurantKitchen.addMeal(3, "Qozonkabob", 35000);

        restaurantKitchen.refillProduct("Meat", 30000);
        restaurantKitchen.refillProduct("Oil", 10000);
        restaurantKitchen.refillProduct("Potatoes", 50000);
        restaurantKitchen.refillProduct("Onion", 20000);
        restaurantKitchen.refillProduct("Rice", 25000);



        System.out.println(restaurantKitchen.getPrice(1));

        restaurantKitchen.addRecipe(1, "Meat", 1000);
        restaurantKitchen.addRecipe(1, "Oil", 400);
        restaurantKitchen.addRecipe(1, "Onion", 500);
        restaurantKitchen.addRecipe(1, "Rice", 1000);

        restaurantKitchen.addRecipe(2, "Meat", 1200);
        restaurantKitchen.addRecipe(2, "Oil", 500);
        restaurantKitchen.addRecipe(2, "Onion", 600);

        boolean mealAvailable = restaurantKitchen.availableMeal(1);

        restaurantKitchen.sell(1);
        restaurantKitchen.sell(2);
        restaurantKitchen.sell(1);
        restaurantKitchen.sell(3);

        System.out.println(restaurantKitchen.availableProduct("Oil"));

        List<MealRecipes> sortedSoldMealRecipes = restaurantKitchen.preparedMeal();
        for (MealRecipes mr :
                sortedSoldMealRecipes) {
            System.out.println(mr);
        }

    }
}
