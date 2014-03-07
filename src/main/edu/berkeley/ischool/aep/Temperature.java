package edu.berkeley.ischool.aep;

/**
 * Created by ajrenold on 2/14/14.
 */
public class Temperature extends Unit {

    public static Temperature Fahrenheit = new Temperature(1, "FAHRENHEIT");
    public static Temperature Celsius = new Temperature(1, "CELSIUS");

    private Temperature(int conversionFactor, String name) {
        super(conversionFactor, name);
    }

    @Override
    public double convertTo(double size, Unit otherUnits) {
        if(otherUnits.name == "CELSIUS"){
            return 5/9.0 *  (size - 32);
        } else {
            return (9/5.0 * size) + 32;
        }
        //return size * conversionFactor / otherUnits.conversionFactor;
    }
}
