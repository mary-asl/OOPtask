import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Building {
    private int buildingNumber;
    private ArrayList<Room> rooms = new ArrayList<>();
    Logger logger = LogManager.getLogger();

    public Building(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void add(Room room) {
        this.rooms.add(room);
    }

    public Room getRoom(Integer number) {
        return rooms.get(number - 1);
    }

    @Override
    public String toString() {
        return "\nBuilding " + buildingNumber + "\n" + rooms;
    }

    public void describe() {
        logger.info(toString());
    }
}
