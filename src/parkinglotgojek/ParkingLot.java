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

    public void printStatus() {
        System.out.printf("Slot No. Registration No Colour \n");
        for (Map.Entry<Integer, Car> entry : parkingLot.entrySet())
        {
            Car v = entry.getValue();
            if (v != null) {
                System.out.printf("%d %s %s\n", entry.getKey(), v.getRegPlate(), v.getColor());
            }
        }
    }
}
