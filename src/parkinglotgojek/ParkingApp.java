package parkinglotgojek;

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

        if (values[0].equals("create_parking_lot")) {
            parkingLot = new ParkingLot(Integer.parseInt(values[1])); //TODO handle invalid args
        }
        else if (values[0].equals("status")) {
            parkingLot.printStatus();
        }
        else if (values[0].equals("park")) {
            Car newCar = new Car(values[1], values[2]);
            parkingLot.park(newCar);
        }
        else if (values[0].equals("leave")) {
            parkingLot.leave(Integer.parseInt(values[1]));
        }
        else if (values[0].equals("exit")) {
            keepRun = false;
        }
        else {
            System.out.printf("Unknown command: %s \n", values[0]);
        }

        return keepRun;
    }
}