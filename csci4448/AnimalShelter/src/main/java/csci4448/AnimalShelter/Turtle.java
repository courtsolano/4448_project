package csci4448.AnimalShelter;

import java.util.*;

/**
 * The turtle class is a subclass of the animal class, turtles have different types
 */
public class Turtle extends Animal {

    /**
     * Default constructor for a turtle object
     */
    public Turtle() {
        type = "";
    }

    /**
     * The type of turtle, for example box or red-eared slider
     */
    public String type;

    /**
     * The constructor for a turtle object
     * @param _type the type of turtle provided
     */
    public Turtle(String _type) {
        type = _type;
    }

    /**
     * The method to access the type of a turtle object
     * @return the type of turtle
     */
    public String getType() {
        return type;
    }

    /**
     * The method to set the type of a turtle object
     * @param _type the type of the current turtle object
     */
    public void setType(String _type) {
        type = _type;
    }

}