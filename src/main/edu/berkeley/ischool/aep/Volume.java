package edu.berkeley.ischool.aep;

/**
 * Created by ajrenold on 2/14/14.
 */
public class Volume extends Unit {

    public static Volume TEASPOON = new Volume(1, "TEASPOON");
    public static Volume TABLESPOON = new Volume(3, "TABLESPOON");
    public static Volume OUNCE = new Volume(3*2, "TABLESPOON");
    public static Volume CUP = new Volume(3*2*8, "CUP");

    private Volume(int conversionFactor, String name) {
        super(conversionFactor, name);
    }

}
