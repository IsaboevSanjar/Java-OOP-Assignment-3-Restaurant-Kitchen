package uz.muu;

public class Waiters {
    int ID;
    String name_surname;

    public Waiters(int ID, String name_surname) {
        this.ID = ID;
        this.name_surname = name_surname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName_surname() {
        return name_surname;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
    }

    @Override
    public String toString() {
        return "Waiters{" +
                "ID=" + ID +
                ", name_surname='" + name_surname + '\'' +
                '}';
    }
}
