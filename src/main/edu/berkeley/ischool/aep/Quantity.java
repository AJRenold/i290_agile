package edu.berkeley.ischool.aep;

import java.util.Collections;
import java.util.List;

/**
 * Created by ajrenold on 2/14/14.
 *
 * The Quantity class understands a unit
 */

public class Quantity implements Comparable<Quantity>{

    protected double value;
    protected Unit unit;

    protected Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean isBetter(Object other) {
        double otherValue = ((Quantity) other).convertTo(this.unit);
        return this.value > otherValue;
    }

    public static Object best(List quantity_list) {
        Collections.sort(quantity_list);
        return quantity_list.get(0);
    }

    protected double convertTo(Unit otherUnit){
        if(!otherUnit.getClass().isInstance(this.unit)) {
            throw new RuntimeException("You can't convert " + this.unit + " to " + otherUnit);
        }
        if(this.unit == otherUnit) {
            return this.value;
        }
        return unit.convertTo(this.value, otherUnit);
    }

    @Override
    public int compareTo(Quantity other) {
        if(this.isBetter(other)) return -1;
        if(!this.isBetter(other)) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) return true;
        if(!(other instanceof Quantity)) return false;
        //return value == ((Quantity) other).convert(this.unit).value;
        //return value - ((Quantity) other).convert(this.unit).value < 0.00001;
        double otherValue = ((Quantity) other).convertTo(this.unit);
        return this.value == otherValue;
    }

    @Override
    public int hashCode() {
        long longBits = Double.doubleToLongBits(this.value);
        return (int)(longBits ^ longBits >>>32);
    }

    @Override
    public String toString() {
        return "Value: " + value + " Unit: " + unit;
    }

}
