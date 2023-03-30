package uz.muu;

import java.util.List;

public class RestaurantKitchen {

    public void addMeal(int id, String name, double price) {
    }

    public double getPrice(int mealId) {
        return 0.0;
    }

    public void addRecipe(int mealId, String productName, double amount) {
    }

    public boolean sell(int mealId) {
        return false;
    }

    public void refillProduct(String productName, int amount) {
    }

    public boolean availableMeal(int mealID) {
        return false;
    }

    public double availableProduct(String productName) {
        return -1;
    }

    public List<MealRecipes> preparedMeal(){
        return null; }
}
