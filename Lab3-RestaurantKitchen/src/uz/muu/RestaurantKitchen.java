package uz.muu;

import javax.sound.midi.Track;
import java.util.*;

public class RestaurantKitchen {
    List<Kitchen> mealList = new LinkedList<>();
    List<Product> productList = new LinkedList<>();
    List<MealRecipes> recipesList = new LinkedList<>();
    List<Waiters> waitersList = new LinkedList<>();

    List<Prepared> sold = new LinkedList<>();

    List<WaiterSalary> waiterSalaryList = new LinkedList<>();


    int totalMealSold=0;
    int totalRestaurantProfit=0;

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

    public void sell(int mealId, String waiter_name) {
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
        } else {
            System.out.println(mealId + " sold");
            int counter = 0;
            for (Kitchen recipes : mealList) {

                if (mealId == recipes.mealID) {
                    if (counter == 0) {
                        boolean waiter_exist = false;
                        for (WaiterSalary waiter : waiterSalaryList) {
                            if (waiter.getName_surname().equals(waiter_name)) {
                                waiter_exist = true;
                                double salary = (waiter.getSalary() + recipes.getSellingPrice() * 0.1);
                                waiter.setSalary((int) salary);
                                totalMealSold=(int) (totalMealSold+recipes.getSellingPrice());
                                totalRestaurantProfit=(int) (totalRestaurantProfit+(recipes.getSellingPrice()-recipes.getSellingPrice()*0.1));
                                counter += 1;
                                break;
                            }
                        }
                        if (!waiter_exist) {
                            System.out.println(waiter_name + " does not exist.");
                        }
                    }
                    boolean isPrepared = false;
                    for (Prepared prepared : sold) {
                        if (prepared.name.equals(recipes.mealName)) {
                            isPrepared = true;
                            prepared.setCount(prepared.getCount() + 1);
                            break;
                        }
                    }
                    if (!isPrepared) {
                        sold.add(new Prepared(recipes.mealName, 1));
                    }
                }
            }
        }
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

    public List<Prepared> preparedMeal() {
        sorted(sold);
        return sold;
    }

    public List<WaiterSalary> waitersSalary() {
        sorted_waiters(waiterSalaryList);
        return waiterSalaryList;
    }

    private void sorted(List<Prepared> sold) {
        sold.sort(new Comparator<Prepared>() {
            @Override
            public int compare(Prepared o1, Prepared o2) {

                return Integer.compare(o2.getCount(), o1.getCount());
            }
        });
    }

    private void sorted_waiters(List<WaiterSalary> salaries) {
        salaries.sort(new Comparator<WaiterSalary>() {
            @Override
            public int compare(WaiterSalary o1, WaiterSalary o2) {

                return Integer.compare(o1.getSalary(), o2.getSalary());
            }
        });
    }


    public void addWaiters(int id, String name_surname) {
        boolean isExist = false;
        for (Waiters waiters : waitersList) {
            if (waiters.ID == id) {
                System.out.println(name_surname + " is existed waiter");
                isExist = true;
            }
        }
        if (!isExist) {
            waitersList.add(new Waiters(id, name_surname));
            waiterSalaryList.add(new WaiterSalary(name_surname, 0));
        }
    }
    public void totalMealSoldCost(){
        System.out.println("Total meal sold: "+totalMealSold);
    }
    public void totalRestaurantProfit(){
        System.out.println("Total restaurant profit: "+totalRestaurantProfit);
    }
}
