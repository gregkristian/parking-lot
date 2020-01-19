package parkinglotgojek;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Test ParkingLot class
 *
 * @author Gregorius Kristian Purwidi
 */
public class ParkingLotTest {

    /**
     * Test construction of ParkingLot
     */
    @Test
    public void testCreateParkingLots() {
        // Construct two parking lot with different size
        ParkingLot lot1 = new ParkingLot(5);
        ParkingLot lot2 = new ParkingLot(10);

        // Assert the creation
        assertEquals("Parking lot 1 size not as expected", 5, lot1.getParkingLotMap().size());
        assertEquals("Parking lot 2 size not as expected", 10, lot2.getParkingLotMap().size());
    }

    /**
     * Test car parking and leaving operation
     */
    @Test
    public void testParkAndLeave() {
        Map<Integer, Car> lotMap = null;

        // Construct a lot with size 3
        ParkingLot lot = new ParkingLot(3);

        // Define and construct 4 cars
        Car[] cars = new Car[4];
        String[] regPlates = {"KA-1111", "KB-2222", "KC-3333", "KD-4444"};
        String[] colours = {"Wonderful White", "Bloody Blue", "Gentle Green", "Radiant Red"};

        for (int i = 0; i < 4; i++) {
            cars[i] = new Car(regPlates[i], colours[i]);
        }

        // Park 3 cars. Assert the result
        for (int i = 0; i < 3; i++) {
            lot.park(cars[i]);
        }
        lotMap = lot.getParkingLotMap();
        assertEquals("Car parked on slot 1 not as expected", cars[0], lotMap.get(1));
        assertEquals("Car parked on slot 2 not as expected", cars[1], lotMap.get(2));
        assertEquals("Car parked on slot 3 not as expected", cars[2], lotMap.get(3));

        // Park 1 more car, but reject car since lot is full. Assert the result
        lot.park(cars[3]);
        assertEquals("Car parked on slot 1 not as expected", cars[0], lotMap.get(1));
        assertEquals("Car parked on slot 2 not as expected", cars[1], lotMap.get(2));
        assertEquals("Car parked on slot 3 not as expected", cars[2], lotMap.get(3));

        // Car on lot 2 is leaving. Assert the result
        lot.leave(2);
        assertEquals("Car parked on slot 1 not as expected", cars[0], lotMap.get(1));
        assertEquals("Car parked on slot 2 not as expected", null, lotMap.get(2));
        assertEquals("Car parked on slot 3 not as expected", cars[2], lotMap.get(3));

        // Attempt to park 1 car again. Now it should park at slot 2. Assert the result
        lot.park(cars[3]);
        assertEquals("Car parked on slot 1 not as expected", cars[0], lotMap.get(1));
        assertEquals("Car parked on slot 2 not as expected", cars[3], lotMap.get(2));
        assertEquals("Car parked on slot 3 not as expected", cars[2], lotMap.get(3));

        // All car are leaving. Map still keeps the size, but values are all null
        lot.leave(1);
        lot.leave(2);
        lot.leave(3);

        assertEquals("Parking lot size not as expected", 3, lot.getParkingLotMap().size());
        assertEquals("Parking slot 1 should be empty", null, lotMap.get(1));
        assertEquals("Parking slot 2 should be empty", null, lotMap.get(2));
        assertEquals("Parking slot 3 should be empty", null, lotMap.get(3));
    }

    /**
     * Test goverment-related information finder. TODO add test for invalid values?
     */
    @Test
    public void testInformationFinder() {
        // Construct a lot with size 7
        ParkingLot lot = new ParkingLot(7);

        // Construct 7 cars and park it
        Car[] cars = new Car[7];
        String[] regPlates = {"KA-01", "KB-02", "KC-03", "KD-04", "KE-05", "KF-06", "KG-07"};
        String[] colours = {"White", "Blue", "Green", "White", "Blue", "Green", "White"};

        for (int i = 0; i < 7; i++) {
            cars[i] = new Car(regPlates[i], colours[i]);
            lot.park(cars[i]);
        }

        // Get slot number of car KD-04. Assert the result
        int actualSlot = lot.getSlotNumberOfARegPlate(regPlates[3]);
        assertEquals("Car KD-04 not parked in expected slot", 4, actualSlot);

        // Get list of slot numbers of white and green car. Assert the result
        List<Integer> expSlots = Arrays.asList(1, 4, 7);
        List<Integer> actualSlots = lot.getListOfSlotNumbersOfColour("White");
        assertEquals("Slot numbers don't match for white cars", expSlots, actualSlots);

        expSlots = Arrays.asList(3, 6);
        actualSlots = lot.getListOfSlotNumbersOfColour("Green");
        assertEquals("Slot numbers don't match for green cars", expSlots, actualSlots);

        // Get list of registration plates of blue car. Assert the result
        List<String> expRegPlates = Arrays.asList("KB-02", "KE-05");
        List<String> actualRegPlates = lot.getListOfRegPlatesOfColour("Blue");
        assertEquals("Reg plates don't match for blue cars", expRegPlates, actualRegPlates);
    }

    // TODO test printStatus()
}
