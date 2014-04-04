package edu.berkeley.ischool.aep;

/**
 * Created by ajrenold on 2/14/14.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

// Use a Quantity class which understands size and unit

public class QuantityTest {


    // 5C, 0C, 3C, 1C = 5c is best
    // with Lists or Array
    @Test
    public void findBestCelsiusOfFive(){

        List<ScaledQuantity> quantity_list = new ArrayList<ScaledQuantity>();
        quantity_list.add(new ScaledQuantity(32, Temperature.Fahrenheit));
        quantity_list.add(new ScaledQuantity(3, Temperature.Celsius));
        quantity_list.add(new ScaledQuantity(1, Temperature.Celsius));
        quantity_list.add(new ScaledQuantity(5, Temperature.Celsius));

        assertEquals(Quantity.best(quantity_list), new ScaledQuantity(5, Temperature.Celsius));

        ScaledQuantity[] quantity_array = new ScaledQuantity[]{
                new ScaledQuantity(3, Temperature.Celsius),
                new ScaledQuantity(32, Temperature.Fahrenheit),
                new ScaledQuantity(5, Temperature.Celsius),
                new ScaledQuantity(1, Temperature.Celsius)
        };
        Arrays.sort(quantity_array);
        assertEquals(quantity_array[0], new ScaledQuantity(5, Temperature.Celsius));
    }

    // 10F, 2Y, 3Y, 4Y = 4Y is best
    // with Lists
    @Test
    public void findBestDistance(){

        List<ArithmeticQuantity> quantity_list = new ArrayList<ArithmeticQuantity>();
        quantity_list.add(new ArithmeticQuantity(10, Distance.FEET));
        quantity_list.add(new ArithmeticQuantity(2, Distance.YARDS));
        quantity_list.add(new ArithmeticQuantity(9, Distance.FEET));
        quantity_list.add(new ArithmeticQuantity(4, Distance.YARDS));
        assertEquals(Quantity.best(quantity_list), new ArithmeticQuantity(4, Distance.YARDS));

    }

    // 10F, 2Y, 3Y, 4Y = 4Y is best
    // with Lists
    @Test(expected = RuntimeException.class)
    public void findBestDistanceRuntimeException(){

        List<ArithmeticQuantity> quantity_list = new ArrayList<ArithmeticQuantity>();
        quantity_list.add(new ArithmeticQuantity(10, Volume.CUP));
        quantity_list.add(new ArithmeticQuantity(2, Distance.YARDS));
        quantity_list.add(new ArithmeticQuantity(9, Distance.FEET));
        quantity_list.add(new ArithmeticQuantity(4, Distance.YARDS));

        assertEquals(Quantity.best(quantity_list), new ArithmeticQuantity(4, Distance.YARDS));

    }

    @Test(expected = NullPointerException.class)
    public void findBestDistanceNullException(){
        assertEquals(Quantity.best(null), new ArithmeticQuantity(4, Distance.YARDS));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findBestDistanceArrayIndexException(){
        List<ArithmeticQuantity> quantity_list = new ArrayList<ArithmeticQuantity>();
        assertEquals(Quantity.best(quantity_list), new ArithmeticQuantity(4, Distance.YARDS));
    }

    // 1C > 0C
    @Test
    public void oneCelsiusIsBetterThanZeroCelsius(){
        ScaledQuantity zero_celsius = new ScaledQuantity(0, Temperature.Celsius);
        ScaledQuantity one_celsius = new ScaledQuantity(1, Temperature.Celsius);

        assertTrue(one_celsius.isBetter(zero_celsius));
        assertTrue(!zero_celsius.isBetter(one_celsius));
    }

    // 20 inches > 1 foot
    @Test
    public void twentyInchesIsBetterThanOneFoot(){
        ArithmeticQuantity twenty_inch = new ArithmeticQuantity(20, Distance.INCHES);
        ArithmeticQuantity one_foot = new ArithmeticQuantity(1, Distance.FEET);

        assertTrue(twenty_inch.isBetter(one_foot));
        assertTrue(!one_foot.isBetter(twenty_inch));
    }

    // Fahrenheit to Celsius
    // 32 F = 0 C
    //
    @Test
    public void thirtyTwoFIsEqualToZeroC(){
        ScaledQuantity fahrenheit = new ScaledQuantity(32, Temperature.Fahrenheit);
        ScaledQuantity celsius = new ScaledQuantity(0, Temperature.Celsius);

        assertEquals(fahrenheit, celsius);
        assertEquals(celsius, fahrenheit);
        assertEquals(fahrenheit, fahrenheit);
    }

    // 68 F = 20 C
    @Test
    public void sixtyEightFIsEqualToTwentyC(){
        ScaledQuantity fahrenheit = new ScaledQuantity(68, Temperature.Fahrenheit);
        ScaledQuantity celsius = new ScaledQuantity(20, Temperature.Celsius);

        assertEquals(fahrenheit, celsius);
        assertEquals(celsius, fahrenheit);
    }

    // 3 ft = 1 yard
    @Test
    public void threeFeetIsEqualToOneYard(){
        ArithmeticQuantity feet = new ArithmeticQuantity(3, Distance.FEET);
        ArithmeticQuantity yards = new ArithmeticQuantity(1, Distance.YARDS);

        assertEquals(feet, yards);
        assertEquals(yards, feet);

        //assertEquals(new Quantity(1.5, YARDS), new Quantity(4.5, FEET));
    }

    // 1760 yard = 1 mile
    @Test
    public void OneSevenSixZeroYardsEqualOneMile(){
        ArithmeticQuantity yards = new ArithmeticQuantity(1760, Distance.YARDS);
        ArithmeticQuantity miles = new ArithmeticQuantity(1, Distance.MILES);

        assertEquals(yards, miles);
        assertEquals(miles, yards);
    }

    // 2in + 2in = 4in
    @Test
    public void twoInchPlusTwoInchEqualFourInch(){
        ArithmeticQuantity two_inches = new ArithmeticQuantity(2, Distance.INCHES);
        ArithmeticQuantity two_inches2 = new ArithmeticQuantity(2, Distance.INCHES);

        assertEquals(new ArithmeticQuantity(4, Distance.INCHES), two_inches.add(two_inches2));

    }

    // 1 tablespoon = 3 tsp
    @Test
    public void oneTablespoonEqualThreeTeaspoon(){
        ArithmeticQuantity tbs = new ArithmeticQuantity(1, Volume.TABLESPOON);
        ArithmeticQuantity tsp = new ArithmeticQuantity(3, Volume.TEASPOON);

        //assertEquals(tbs.convert(TEASPOON), tsp);
        //assertEquals(tsp.convert(TABLESPOON), tbs);
        assertEquals(tbs, tsp);
        assertEquals(tsp, tbs);

    }

    // 1 oz = 2 tablespoon
    @Test
    public void oneOunceEqualTwoTablespoon(){
        ArithmeticQuantity oz = new ArithmeticQuantity(1, Volume.OUNCE);
        ArithmeticQuantity tbs = new ArithmeticQuantity(2, Volume.TABLESPOON);

        assertEquals(oz, tbs);
        assertEquals(tbs, oz);


    }

    // 8 oz = 1 cup
    @Test
    public void eightOunceEqualOneCup() {

        ArithmeticQuantity cup = new ArithmeticQuantity(1, Volume.CUP);
        ArithmeticQuantity oz = new ArithmeticQuantity(8, Volume.OUNCE);
        assertEquals(cup, oz);
        assertEquals(oz, cup);

    }

    // 2 tbsp + 1 oz = 12 tsp
    @Test
    public void twoTablespoonPlusOneOunceEqualTwelveTeaspoon(){

        ArithmeticQuantity two_tbsp = new ArithmeticQuantity(2, Volume.TABLESPOON);
        ArithmeticQuantity one_oz = new ArithmeticQuantity(1, Volume.OUNCE);
        assertEquals(two_tbsp.add(one_oz), new ArithmeticQuantity(12, Volume.TEASPOON));
    }

    // 2 in + 8 oz = ?
    @Test(expected = RuntimeException.class)
    public void twoInchesPlusEightOuncesShouldThrowException(){

        ArithmeticQuantity two_in = new ArithmeticQuantity(2, Distance.INCHES);
        ArithmeticQuantity eight_oz = new ArithmeticQuantity(8, Volume.OUNCE);
        two_in.add(eight_oz);
    }

    // 2 in is better than 8 oz = ?
    @Test(expected = RuntimeException.class)
    public void twoInchesIsBetterEightOuncesShouldThrowException(){

        ArithmeticQuantity two_in = new ArithmeticQuantity(2, Distance.INCHES);
        ArithmeticQuantity eight_oz = new ArithmeticQuantity(8, Volume.OUNCE);
        two_in.isBetter(eight_oz);
    }

    /*
    //feet cannot convert to oz
    @Test
    public void feetCannotConvertToOz() {
        Quantity feet = new Quantity(1, Distance.FEET);
        Quantity oz = new Quantity(1, Volume.OUNCE);

        assertEquals(feet, oz);
        //System.out.println(oz);
        //assertEquals(feet.convert(OUNCE), oz);
    }*/

}
