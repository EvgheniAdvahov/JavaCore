package ru.geekbrains.core.lesson4.task4;

/**
 * "Товар"
 */
public class Item {

    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" +
                "Наименование: '" + name + '\'' +
                ", Цена: " + price +
                ']';
    }

}
