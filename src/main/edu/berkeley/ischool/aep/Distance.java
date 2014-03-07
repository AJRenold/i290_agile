package edu.berkeley.ischool.aep;

/**
 * Created by ajrenold on 2/14/14.
 */
public class Distance extends Unit {

    public static Distance INCHES = new Distance(1/12.0, "INCHES");
    public static Distance FEET = new Distance(1, "FEET");
    public static Distance YARDS = new Distance(3, "YARDS");
    public static Distance MILES = new Distance(1760 * 3, "MILES");

    public Distance(double conversionFactor, String name) {
        super(conversionFactor, name);
    }

}
