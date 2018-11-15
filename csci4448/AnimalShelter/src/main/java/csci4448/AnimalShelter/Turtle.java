package csci4448.AnimalShelter;

import java.util.*;

/**
 * 
 */
public class Turtle extends Animal {

    /**
     * Default constructor
     */
    public Turtle() {
        type = "";
    }

    /**
     * 
     */
    public String type;

    /**
     *
     */
    public Turtle(String _type) {
        type = _type;
    }

    /**
     * @return turtle type
     */
    public String getType() {
        return type;
    }

    /**
     * @param _type 
     * @return
     */
    public void setType(String _type) {
        // TODO implement here
    }

}