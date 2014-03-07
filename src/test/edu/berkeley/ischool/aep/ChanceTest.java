package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by ajrenold on 1/31/14.
 */
public class ChanceTest {


    @Test
    public void testName() throws Exception {

    }

    // Equality comparison in Java compares objects
    @Test
    public void oneChanceShouldBeEqualToAnother(){

        Chance coinToss = new Chance(0.5);
        Chance dieThrow = new Chance( ((double) 1.0)/6);

        assertFalse(dieThrow.equals(coinToss));
        assertEquals(coinToss, new Chance(0.5));

        assertEquals(new Chance(0.5), coinToss.not());
        assertEquals(new Chance(5.0/6), dieThrow.not());

        //assertEquals(new Chance(0.2), new Chance(0.8).not());
    }

    @Test
    public void equalsShouldWorkAccordingToContract() {
        Chance coinToss = new Chance(0.5);
        assertFalse(coinToss.equals(null));
    }

    @Test
    public void twoChancesAndedShouldBeMultiplied() {
        // 0.5 * 0.5 = 0.25
        Chance coinToss = new Chance(0.5);
        Chance coinToss2 = new Chance(0.5);
        assertEquals(coinToss.and(coinToss2), new Chance(0.25));

        // 0.2 * 0.5 = 0.1
        assertEquals(new Chance(0.2).and(new Chance(0.5)), new Chance(0.1));
    }

}
