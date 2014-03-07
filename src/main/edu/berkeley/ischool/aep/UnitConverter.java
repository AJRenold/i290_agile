package edu.berkeley.ischool.aep;

/**
 * Created by ajrenold on 2/7/14.
 */
public class UnitConverter {

    public static Inches FeetToInches(Feet f) {
        return new Inches(f.getQuantity() / 12);
    }

}
