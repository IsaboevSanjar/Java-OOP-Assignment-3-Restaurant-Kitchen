package uz.muu;

import java.util.Comparator;

public class Prepared  {
    String name;
    int count;

    public Prepared(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Prepared{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

}
