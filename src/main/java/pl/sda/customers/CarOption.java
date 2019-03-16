package pl.sda.customers;

import lombok.Getter;

@Getter
public class CarOption {

    private static int counter = 1;
    private final String name;
    private final int id;
    private final int price;

    {
        id = counter++; // blok inicjalizacujacy
    }

    public CarOption(String name, int id, int price) {
        this.name = name;
        this.price = price;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        CarOption.counter = counter;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
