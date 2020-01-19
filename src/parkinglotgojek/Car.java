package parkinglotgojek;

/**
 * Represents one car
 *
 * @author Gregorius Purwidi
 */
public class Car {
	private String regPlate;
	private String color;

	public Car(String regPlate, String color) {
		this.regPlate = regPlate;
		this.color = color;
	}

	public String getRegPlate() {
		return regPlate;
	}

	public String getColor() {
		return color;
	}
}
