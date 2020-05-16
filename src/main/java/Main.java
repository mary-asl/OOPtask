import exceptions.IlluminanceTooMuchException;
import exceptions.SpaceUsageTooMuchException;
import furniture.Chair;
import furniture.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        System.setProperty("Log4j.configurationFile", "C:\\Users\\Маша\\IdeaProjects\\OOPtask\\src\\main\\resources\\log4j.xml");
        Logger logger = LogManager.getLogger();
        Building building1 = new Building(1);
        building1.add(new Room(1, 20.0, 1));
        building1.add(new Room(2, 30.0, 3));
        try {
            building1.getRoom(1).add(new Table("computer table", 2.0));
            building1.getRoom(1).add(new Chair("office chair", 1.0));
            building1.getRoom(2).add(new Table("large table", 5.0));
            building1.getRoom(1).add(new Lamp(220));
            building1.getRoom(1).add(new Lamp(250));
            building1.getRoom(2).add(new Lamp(220));

        } catch (SpaceUsageTooMuchException e) {
            logger.error("There is no place for putting items.");
        } catch (IlluminanceTooMuchException e) {
            logger.error("Too much light. You can't put any lamps");
        }

        building1.describe();
    }
}
