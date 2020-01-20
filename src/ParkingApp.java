import java.util.Scanner;

/**
 * Application to manage parking lot
 *
 * @author Gregorius Kristian Purwidi
 */
public class ParkingApp {

    private static ParkingLot parkingLot = null;
    /**
     * @param args
     */
    public static void main(String[] args) {
        boolean keepRun = true;

        System.out.println("Hello..."); //TODO rm this

        try (Scanner in = new Scanner(System.in)) {
            //Read stdin until exit
            while (keepRun) {
                keepRun = runCommand(in.nextLine());
            }
        } // TODO add catch?

        System.out.println("Exiting..."); //TODO rm this
    }

    public static boolean runCommand(String command) {
        boolean keepRun = true;
        String values[] = command.split("\\s+");

        switch (values[0]) {
            case "create_parking_lot":
                parkingLot = new ParkingLot(Integer.parseInt(values[1])); //TODO handle invalid args
                break;
            case "status":
                parkingLot.printStatus();
                break;
            case "park":
                Car newCar = new Car(values[1], values[2]);
                parkingLot.park(newCar);
                break;
            case "leave":
                parkingLot.leave(Integer.parseInt(values[1]));
                break;
            case "exit":
                keepRun = false;
                break;
            case "slot_number_for_registration_number":
                parkingLot.getSlotNumberOfARegPlate(values[1]);
                break;
            case "slot_numbers_for_cars_with_colour":
                parkingLot.getListOfSlotNumbersOfColour(values[1]);
                break;
            case "registration_numbers_for_cars_with_colour":
                parkingLot.getListOfRegPlatesOfColour(values[1]);
                break;
            default:
                // Unknown command. Do nothing
        }

        return keepRun;
    }
}