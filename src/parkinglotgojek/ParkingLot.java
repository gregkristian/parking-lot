package parkinglotgojek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents one parking lot
 *
 * @author Gregorius Kristian Purwidi
 */
public class ParkingLot {

    private Map<Integer, Car> parkingLot;

    // Constructor
    public ParkingLot(int size) {
        this.parkingLot = new HashMap<Integer, Car>();
        //Lot number starts from 1
        for (int i = 1; i <= size; i++) {
            parkingLot.put(Integer.valueOf(i), null);
        }
        System.out.printf("Created a parking lot with %d slots\n", parkingLot.size());
    }

    //Print parking lot status
    public void printStatus() {
        System.out.printf("Slot No. Registration No Colour \n");
        // TODO try with stream
        for (Map.Entry<Integer, Car> entry : parkingLot.entrySet())
        {
            Car v = entry.getValue();
            if (v != null) {
                System.out.printf("%d %s %s\n", entry.getKey(), v.getRegPlate(), v.getColour());
            }
        }
    }

    //Park one new car
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

    //Handle one leaving car
    public void leave(int slotNo) {
        parkingLot.put(Integer.valueOf(slotNo), null);
        System.out.printf("Slot number %d is free\n", slotNo);
    }

    // Handle government regulation: get slot number in which a car with a given registration number is parked
    public int getSlotNumberOfARegPlate(String regPlate) {
        int slotNumber = 0;
        for (Map.Entry<Integer, Car> entry : parkingLot.entrySet())
        {
            if (entry.getValue().getRegPlate().equals(regPlate)) {
                slotNumber = entry.getKey().intValue();
                break;
            }
        }
        return slotNumber;
    }

    // Handle government regulation: get slot numbers of all slots where a car of a particular colour is parked.
    public List<Integer> getListOfSlotNumbersOfColour(String colour) {
        List<Integer> listOfSlotNumbers = new ArrayList<>();
        // TODO try with stream
        for (Map.Entry<Integer, Car> entry : parkingLot.entrySet())
        {
            if (entry.getValue().getColour().equals(colour)) {
                listOfSlotNumbers.add(entry.getKey().intValue());
            }
        }
        return listOfSlotNumbers;
    }

    // Handle government regulation: get registration numbers of all cars of a particular colour
    public List<String> getListOfRegPlatesOfColour(String colour) {
        List<String> listOfRegPlates = new ArrayList<>();
        // TODO try with stream
        for (Map.Entry<Integer, Car> entry : parkingLot.entrySet())
        {
            if (entry.getValue().getColour().equals(colour)) {
                listOfRegPlates.add(entry.getValue().getRegPlate());
            }
        }
        return listOfRegPlates;
    }

    //Only used for testing
    public Map<Integer, Car> getParkingLotMap() {
        return parkingLot;
    }
}
