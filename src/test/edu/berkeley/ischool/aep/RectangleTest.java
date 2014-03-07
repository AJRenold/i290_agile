package edu.berkeley.ischool.aep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ajrenold on 1/24/14.
 */

public class RectangleTest {

    @Test
    public void shouldReturnAreaOfTenForTwoByFiveRectangle(){
        Rectangle rectangle = new Rectangle(5, 2, 0, 0);
        assertEquals(10, rectangle.area());
    }

    @Test
    public void shouldReturnAreaOfTwelveForThreeByFourRectangle(){
        Rectangle rectangle = new Rectangle(3, 4, 0, 0);
        assertEquals(12, rectangle.area());
    }
}
