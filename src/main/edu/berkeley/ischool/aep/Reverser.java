package edu.berkeley.ischool.aep;

/**
 * Created by ajrenold on 4/4/14.
 */
public class Reverser {

    public static String reverse(String toReverse) {
        if(toReverse.length() == 1){
            return toReverse;
        }
        return reverse(toReverse.substring(1)) + toReverse.charAt(0);
    }
}
