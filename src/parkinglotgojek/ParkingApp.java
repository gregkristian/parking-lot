package parkinglotgojek;

import java.util.Scanner;

/**
 * Application to manage parking lot
 *
 * @author Gregorius Purwidi
 */
public class ParkingApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //Read stdin until exit
        //TODO check support in command line
        ParkingLot parkingLot = null;
        boolean keepRun = true;

        try (Scanner in = new Scanner(System.in)) {
            while (keepRun) {
                String[] values = in.nextLine().split("\\s+");

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
            }
        } // TODO add catch?
        System.out.println("Exiting..."); //TODO rm this
    }
}