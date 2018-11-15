package csci4448.AnimalShelter;

import java.util.*;

/**
 * 
 */
public class Fish extends Animal {

    /**
     * Default constructor
     */
    public Fish() {
        waterType = "";
    }

    /**
     * 
     */
    public String waterType;

    /**
     *
     */
    public Fish(String _waterType) {
        waterType = _waterType;
    }

    /**
     * @return water type
     */
    public String getWaterType() {
        return waterType;
    }

    /**
     * @param _waterType water type
     */
    public void setWaterType(String _waterType) {
        waterType = _waterType;
    }

}