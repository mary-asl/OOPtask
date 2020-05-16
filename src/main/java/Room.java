import exceptions.IlluminanceTooMuchException;
import exceptions.SpaceUsageTooMuchException;
import furniture.Item;

import java.util.ArrayList;

public class Room {
    private int roomNumber;
    private double area;
    private int windowsCount;
    private double allFurnitureArea = 0;
    private double allLightPower = 0;
    private final double maxFullSpacePercent = 0.7;
    private final double maxLightPower = 4000;
    private final double minLightPower = 300;
    private final double windowLight = 700;
    private ArrayList<Item> furniture = new ArrayList<>();
    private ArrayList<Lamp> lamps = new ArrayList<>();

    public Room(int roomNumber, double area, int windowsCount) {
        this.roomNumber = roomNumber;
        this.area = area;
        this.windowsCount = windowsCount;
    }

    public void add(Item item) throws SpaceUsageTooMuchException {
        this.furniture.add(item);
        allFurnitureArea += item.getArea();
        if (allFurnitureArea > area * maxFullSpacePercent)
            throw new SpaceUsageTooMuchException();
    }

    public void add(Lamp lamp) throws IlluminanceTooMuchException {
        this.lamps.add(lamp);
        allLightPower += lamp.getLight() + windowLight * getWindowsCount();
        if (minLightPower > allLightPower || allLightPower > maxLightPower) {
            throw new IlluminanceTooMuchException();
        }
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getWindowsCount() {
        return windowsCount;
    }

    public void setWindowsCount(int windowsCount) {
        this.windowsCount = windowsCount;
    }

    public int freeSpacePercent() {
        return 100 - (100 * (int) allFurnitureArea / (int) getArea());
    }

    @Override
    public String toString() {
        return "\nRoom " + roomNumber +
                "\n LightPower " + allLightPower +
                " (" + windowsCount + " windows, " +
                "which give " + windowLight + " illumination, " +
                lamps.size() + " lamps: " + lamps +
                ")\n Square " + area +
                " (Busy space " + allFurnitureArea +
                ", Free space " + (getArea() - allFurnitureArea) +
                ", " + freeSpacePercent() + "% free)" +
                "\n Furniture: " + furniture;
    }
}
