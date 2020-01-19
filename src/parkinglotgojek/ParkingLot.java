package parkinglotgojek;

import java.util.HashMap;
import java.util.Map;

/**
 * Parking lot object
 *
 * @author Gregorius Purwidi
 */
public class ParkingLot {

    private Map<Integer, Car> parkingLot;

    // Constructor
    public ParkingLot(int size) {
        this.parkingLot = new HashMap<Integer, Car>();
        for (int i = 1; i <= size; i++) {
            parkingLot.put(Integer.valueOf(i), null);
        }
        System.out.printf("Created a parking lot with %d slots\n", parkingLot.size());
    }

    //Print parking lot status
    public void printStatus() {
        System.out.printf("Slot No. Registration No Colour \n");
        for (Map.Entry<Integer, Car> entry : parkingLot.entrySet())
        {
            Car v = entry.getValue();
            if (v != null) {
                System.out.printf("%d %s %s\n", entry.getKey(), v.getRegPlate(), v.getColour());
            }
        }
    }

    //Park new car
    public void park(Car newCar) {
        boolean isNewCarAdded = false;
        for (Map.Entry<Integer, Car> entry : parkingLot.entrySet())
        {
            Car v = entry.getValue();
            if (v == null) {
                parkingLot.put(entry.getKey(), newCar);
                isNewCarAdded = true;
                System.out.printf("Allocated slot number: %d\n", entry.getKey());
                break;
            }
        }
        if (!isNewCarAdded) {
            System.out.printf("Sorry, parking lot is full\n");
        }
    }

    //Handle the leaving car
    public void leave(int slotNo) {
        parkingLot.put(Integer.valueOf(slotNo), null);
        System.out.printf("Slot number %d is free\n", slotNo);
    }
}
