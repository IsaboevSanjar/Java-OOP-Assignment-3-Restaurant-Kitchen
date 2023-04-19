package uz.muu;

public class WaiterSalary {
    String name_surname;
    int salary;

    public WaiterSalary(String name_surname, int salary) {
        this.name_surname = name_surname;
        this.salary = salary;
    }

    public String getName_surname() {
        return name_surname;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "WaiterSalary{" +
                "name_surname='" + name_surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
