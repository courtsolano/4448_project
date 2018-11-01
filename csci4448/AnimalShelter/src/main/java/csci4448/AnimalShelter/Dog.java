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
     * @param _activityLevel
     */
    public Dog(int _activityLevel) {
        activityLevel = _activityLevel;
    }

    /**
     * @return
     */
    public int getActivityLevel() {
        return activityLevel;
    }

    /**
     * @param _activityLevel 
     *
     */
    public void setActivityLevel(int _activityLevel) {
        activityLevel = _activityLevel;
    }

}