package edu.berkeley.ischool.aep;

public abstract class Unit {

    protected final double conversionFactor;
    protected final String name;

    public Unit(double conversionFactor, String name) {
        this.conversionFactor = conversionFactor;
        this.name = name;
    }

    public double convertTo(double size, Unit otherUnits) {
        return size * conversionFactor / otherUnits.conversionFactor;
    }

    @Override
    public String toString(){
        return "Units " + name;
    }

}
