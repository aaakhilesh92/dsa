package stream;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    private int weight;
    private String color;

    public Apple(int weight, String color) {
        super();
        this.weight = weight;
        this.color = color;
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Color : " + color + " and weight : " + weight;
    }

    public static List<Apple> getAppleInventory() {
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple(200, "blue"));
        inventory.add(new Apple(140, "green"));
        inventory.add(new Apple(100, "blue"));
        inventory.add(new Apple(160, "green"));
        inventory.add(new Apple(175, "green"));
        return inventory;
    }
}
