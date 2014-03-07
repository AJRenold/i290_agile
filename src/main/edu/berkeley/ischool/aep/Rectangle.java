package edu.berkeley.ischool.aep;

/**
 * Understands a four-sided figure with sides at right angles
 *
 */
public class Rectangle {

    int height, width, top, left;

    public Rectangle( int h, int w, int t, int l) {

        height = h;
        width = w;
        top = t;
        left = l;

    }

    public int area() {

        return height * width;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int h) {

        height = h;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int w){

        width = w;
    }

}
