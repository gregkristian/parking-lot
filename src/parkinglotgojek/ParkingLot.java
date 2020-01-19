package parkinglotgojek;

import java.util.HashMap;
import java.util.Map;

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
}
