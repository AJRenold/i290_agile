package edu.berkeley.ischool.aep;

// Value Object, when an internal rule overrides

/**
 * Created by ajrenold on 1/31/14.
 *
 * Understands the probability of an event
 *
 */
public class Chance {

    private final double probability;

    public Chance( double p ) {
        this.probability = p;
    }

    public Chance not() {
        return new Chance(1 - probability);
    }

    public Chance and(Chance c) {
        return new Chance(probability * c.probability);
    }

    @Override
    public boolean equals(Object other) {
        if(other == this) return true;
        if(!(other instanceof Chance)) return false;
        return probability == ((Chance) other).probability;
    }

    @Override
    public int hashCode() {
        long longBits = Double.doubleToLongBits(probability);
        return (int)(longBits ^ longBits >>>32);
    }

    @Override
    public String toString() {
        return "Value " + probability;
    }
}
