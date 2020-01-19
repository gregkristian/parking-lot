package parkinglotgojek;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

    /**
     * Test construction of Car object with normal arguments. Test the getter and assert the result.
     */
    @Test
    public void testCreateCars() {
        // Define two cars
        String[] regPlate = {"KA-1111", "KB-2222"};
        String[] colour = {"White", "Blue"};

        // Construct two cars and assert the result
        for (int i=0; i<2; i++) {
            Car car = new Car(regPlate[i], colour[i]);

            //TODO specify which car
            assertEquals("Car registration plate not as expected", regPlate[i], car.getRegPlate());
            assertEquals("Car colour not as expected", colour[i], car.getColour());
        }
    }

    /**
     * Test construction of Car object with invalid colour. There is no format requirement on registration plate so it won't be tested
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
        assertEquals("Car colour not as expected", null, car.getColour());
    }
}
