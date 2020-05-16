package furniture;

import interfaces.Items;

public class Item implements Items {
    private String name;
    private double area;

    public Item(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return name + " (Square: " + area + ")";
    }
}


