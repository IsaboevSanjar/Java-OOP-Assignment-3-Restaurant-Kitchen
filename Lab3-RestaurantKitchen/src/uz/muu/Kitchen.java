package uz.muu;

public class Kitchen {
    int mealID;
    String mealName;
    double sellingPrice;

    public Kitchen(int mealID, String mealName, double sellingPrice) {
        this.mealID = mealID;
        this.mealName = mealName;
        this.sellingPrice = sellingPrice;
    }

    public int getMealID() {
        return mealID;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "Kitchen{" +
                "mealID=" + mealID +
                ", mealName='" + mealName + '\'' +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
