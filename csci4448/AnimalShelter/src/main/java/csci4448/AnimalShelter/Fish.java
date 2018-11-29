package csci4448.AnimalShelter;

import java.util.*;

/**
 * A class for Fish objects that is a subclass of Animal
 */
public class Fish extends Animal {

    /**
     * Default constructor for a fish object
     */
    public Fish() {
        waterType = "";
    }

    /**
     * The type of water the fish requires, for example salt water or fresh water
     */
    public String waterType;

    /**
     * The constructor for a fish object
     * @param _waterType the type of water the fish requires to survive
     */
    public Fish(String _waterType) {
        waterType = _waterType;
    }

    /**
     * Gets the string value of the water type that the fish needs
     * @return a string of the fish's water type
     */
    public String getWaterType() {
        return waterType;
    }

    /**
     * Sets the type of water that the fish needs to survive
     * @param _waterType a string of the fish's water type
     */
    public void setWaterType(String _waterType) {
        waterType = _waterType;
    }

}