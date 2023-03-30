package uz.muu;

import javax.sound.midi.Track;
import java.util.LinkedList;
import java.util.List;

public class RestaurantKitchen {
    List<Kitchen> mealList = new LinkedList<>();
    List<Product> productList = new LinkedList<>();
    List<MealRecipes> recipesList = new LinkedList<>();
    List<Kitchen> preparedMeals = new LinkedList<>();

    public void addMeal(int id, String name, double price) {
        boolean mealExist = false;
        for (Kitchen kitchen : mealList) {
            if (kitchen.getMealID() == id || kitchen.getMealName().equals(name)) {
                mealExist = true;
                break;
            }
        }
        if (!mealExist) {
            mealList.add(new Kitchen(id, name, price));
        } else System.out.println("This kind of meal is already exist ( id=" + id + " name=" + name + ")");
    }

    public double getPrice(int mealId) {
        for (Kitchen kitchen : mealList) {
            if (kitchen.getMealID() == mealId) {
                return kitchen.getSellingPrice();
            }
        }
        return -1.0;
    }

    public void addRecipe(int mealId, String productName, double amount) {
        recipesList.add(new MealRecipes(mealId, productName, amount));
    }

    public void sell(int mealId) {
        boolean invalidId = true;
        boolean availableMeal = true;
        for (MealRecipes recipes : recipesList) {
            // if the meal id in recipe == argument mealID
            if (recipes.getMealID() == mealId) {
                invalidId = false;
                // if the amount of the meal in recipe is enough in product (zahira) amount
                if (availableMeal(mealId)) {
                    for (Product product : productList) {
                        if (product.getProductName().equals(recipes.getProductName())) {
                            double newAmount = product.getAmount() - recipes.getAmount();
                            refillProduct(recipes.getProductName(), newAmount, false);
                            break;
                        }
                    }

                } else availableMeal = false;
            }
        }
        if (invalidId) {
            System.out.println("Invalid Meal ID " + mealId);
        }
        if (!availableMeal) {
            System.out.println("Not available meal " + mealId);
        } else System.out.println(mealId + " sold");
    }

    public void refillProduct(String productName, double amount, boolean refill) {
        boolean newProduct = true;
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                newProduct = false;
                if (refill) {
                    product.setAmount(product.getAmount() + amount);
                } else {
                    product.setAmount(amount);
                }
            }
        }
        if (newProduct) {
            productList.add(new Product(productName, amount));
        }
    }

    // Agar ritsepdagi yozilgan mahsulot qiymati ombordagi mahsulot zahirasidan kam bolgandagina ovqat pishirishimiz mumkin
    public boolean availableMeal(int mealID) {
        boolean available = false;
        // First we are finding meal id in recipesList
        for (MealRecipes recipes : recipesList) {
            if (recipes.getMealID() == mealID) {
                // id found
                // we are using loop to find the name of the mealID in product list
                for (Product product : productList) {
                    if (recipes.getProductName().equals(product.getProductName())) {
                        // productName found
                        // Agar ritsepdagi yozilgan mahsulot qiymati ombordagi mahsulot zahirasidan kam bolgandagina ovqat pishirishimiz mumkin
                        if (recipes.getAmount() <= product.getAmount()) {
                            available = true;
                        } else return false;
                        break;
                    }
                }
            }
        }
        return available;
    }

    public double availableProduct(String productName) {
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                return product.getAmount();
            }
        }
        return -1;
    }

    public List<MealRecipes> preparedMeal() {
        return recipesList;
    }
}
