package csci4448.AnimalShelter;

import java.util.*;

/**
 * 
 */
public class Dog extends Animal {

    /**
     *
     */
    public int activityLevel;


    /**
     * Default constructor
     */
    public Dog() {
        activityLevel = 0;
    }

    /**
     * @param _activityLevel activity level
     */
    public Dog(int _activityLevel) {
        activityLevel = _activityLevel;
    }

    /**
     * @return activity level
     */
    public int getActivityLevel() {
        return activityLevel;
    }

    /**
     * @param _activityLevel activity level
     *
     */
    public void setActivityLevel(int _activityLevel) {
        activityLevel = _activityLevel;
    }

}