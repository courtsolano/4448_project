package csci4448.AnimalShelter;

import java.util.*;

/**
 * A class for Dog objects that is a subclass of Animal
 */
public class Dog extends Animal {

    /**
     * The level of activity of the dog from 1-10, a smaller number indicates a less active dog
     */
    public int activityLevel;


    /**
     * Default constructor for a Dog object
     */
    public Dog() {
        activityLevel = 0;
    }

    /**
     * The constructor for a Dog object
     * @param _activityLevel activity level
     */
    public Dog(int _activityLevel) {
        activityLevel = _activityLevel;
    }

    /**
     * Gets the activity level of the dog object it is called on
     * @return how active the dog is
     */
    public int getActivityLevel() {
        return activityLevel;
    }

    /**
     * Sets the activity level of the dog object it is called on
     * @param _activityLevel how active the dog is
     */
    public void setActivityLevel(int _activityLevel) {
        activityLevel = _activityLevel;
    }

}