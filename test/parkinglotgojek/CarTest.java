package parkinglotgojek;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test Car class
 *
 * @author Gregorius Kristian Purwidi
 */
public class CarTest {

    /**
     * Test construction of Car object with normal arguments. Test the getter and assert the result.
     */
    @Test
    public void testCreateCars() {
        // Define two cars
        String[] regPlates = {"KA-1111", "KB-2222"};
        String[] colours = {"Shocking Pink", "Amazing Amber"};

        // Construct two cars and assert the result
        for (int i=0; i<2; i++) {
            Car car = new Car(regPlates[i], colours[i]);

            //TODO specify which car
            assertEquals("Car registration plate not as expected", regPlates[i], car.getRegPlate());
            assertEquals("Car colour not as expected", colours[i], car.getColour());
        }
    }

    /**
     * Test construction of Car object with unusual arguments.
     * There is no format requirement on number plates and colour (colour could be hex, for example),
     * so Car instance would be constructed as it is
     */
    @Test
    public void testCreateCarsWithInvalidColour() {
        // Define a car
        String regPlate = "KC-3333";
        String colour = "123";

        // Construct a car
        Car car = new Car(regPlate, colour);

        // Assert that car object is created, but colour should be null
        assertEquals("Car registration plate not as expected", regPlate, car.getRegPlate());
        assertEquals("Car colour not as expected", colour, car.getColour());
    }
}
