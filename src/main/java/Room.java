import exceptions.IlluminanceTooMuchException;
import exceptions.SpaceUsageTooMuchException;
import furniture.Item;

import java.util.ArrayList;

public class Room {
    private int roomNumber;
    private double area;
    private int windowsCount;
    private final double maxFullSpacePercent = 70;
    private final double maxLightPower = 4000;
    private final int windowLight = 700;
    private ArrayList<Item> furniture = new ArrayList<>();
    private ArrayList<Lamp> lamps = new ArrayList<>();

    public Room(int roomNumber, double area, int windowsCount) {
        this.roomNumber = roomNumber;
        this.area = area;
        this.windowsCount = windowsCount;
    }

    public void add(Item item) throws SpaceUsageTooMuchException {
        if (isSpaceUsageTooMuch(item.getArea()) == true)
            furniture.add(item);
        else
            throw new SpaceUsageTooMuchException();
    }


    public void add(Lamp lamp) throws IlluminanceTooMuchException {
        if (isIlluminanceTooMuch(lamp.getLight()) == true)
            lamps.add(lamp);
        else
            throw new IlluminanceTooMuchException();
    }

    public ArrayList<Lamp> getLamps() {
        return lamps;
    }

    public ArrayList<Item> getFurniture() {
        return furniture;
    }

    public int getTotalLightOfLamps() {
        ArrayList<Lamp> lamps = getLamps();
        int totalLight = 0;
        for (Lamp l : lamps) {
            totalLight += l.getLight();
        }
        return totalLight;
    }

    public double getFoolSpace() {
        ArrayList<Item> furniture = getFurniture();
        double totalSquare = 0;
        for (Item f : furniture) {
            totalSquare += f.getArea();
        }
        return totalSquare;
    }

    private boolean isIlluminanceTooMuch(int light) {
        int totalLight = getTotalLightOfLamps() + light;
        int x = totalLight + (getWindowsCount() * windowLight);
        if (x < maxLightPower) {
            return true;
        }
        return false;
    }

    private boolean isSpaceUsageTooMuch(double square) {
        double totalSquare = getFoolSpace() + square;
        double roomSquare = getArea();
        double x = (100 * totalSquare) / roomSquare;
        if (x < maxFullSpacePercent) {
            return true;
        }
        return false;
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
        return 100 - (100 * (int) getFoolSpace() / (int) getArea());
    }

    @Override
    public String toString() {
        return "\nRoom " + roomNumber +
                "\n LightPower " + (getTotalLightOfLamps() + getWindowsCount() * windowLight) +
                " (" + windowsCount + " windows, " +
                "which give " + windowLight + " illumination, " +
                lamps.size() + " lamps: " + lamps +
                ")\n Square " + area +
                " (Busy space " + getFoolSpace() +
                ", Free space " + (getArea() - getFoolSpace()) +
                ", " + freeSpacePercent() + "% free)" +
                "\n Furniture: " + furniture;
    }
}
