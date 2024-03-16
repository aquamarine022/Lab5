package me.masha.models;

import me.masha.utility.Validatable;

/**
 * Class to operate with coordinates
 */
public class Coordinates implements Validatable {
     /**
     *Coordinate x
     *Max value: 717, Can't be null
     */
     private Integer x;
     /**
     *Coordinate y
     */
     private float y;

    /**
     * Constructor
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Coordinates(int x, float y) {
            this.x = x;
            this.y = y;
        }

    /**
     * Method to get formatted string representation of coordinate
     * @return String value
     */
    @Override
    public String toString() {
        return x + ";" + y;
    }

    /**
     * Checker of correct values
     * @return true if value is correct and false if incorrect
     */
    @Override
    public boolean validate() {
        if (x == null) return false;
        return x<718;
    }
}
