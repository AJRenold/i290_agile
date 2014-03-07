package edu.berkeley.ischool.aep;

/**
 * Created by ajrenold on 2/21/14.
 */
public class ArithmeticQuantity extends Quantity {
    public ArithmeticQuantity(double value, Unit unit) {
        super(value, unit);
        if(!Distance.class.isInstance(unit) && !Volume.class.isInstance(unit)) {
            throw new RuntimeException("Cannot create ArithmeticQuantity with unit " + unit);
        }
    }

    public ArithmeticQuantity add(Quantity other) {

        double otherValue = other.convertTo(this.unit);
        return new ArithmeticQuantity(this.value + otherValue, this.unit);
    }

}
