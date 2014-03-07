package edu.berkeley.ischool.aep;

/**
 * Created by ajrenold on 2/21/14.
 */
public class ScaledQuantity extends Quantity {

    public ScaledQuantity(double value, Unit unit) {

        super(value, unit);
        if(!Temperature.class.isInstance(unit)) {
            throw new RuntimeException("Cannot create ArithmeticQuantity with unit " + unit);
        }
    }
}
