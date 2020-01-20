/**
 * Represents one car
 *
 * @author Gregorius Kristian Purwidi
 */
public class Car {
    private String regPlate; // Registration plate
    private String colour;

    public Car(String regPlate, String colour) {
        this.regPlate = regPlate;
        this.colour = colour;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public String getColour() {
        return colour;
    }
}
