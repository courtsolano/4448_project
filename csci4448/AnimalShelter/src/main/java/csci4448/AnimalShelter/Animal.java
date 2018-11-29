package csci4448.AnimalShelter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * The animal class is a superclass that contains features that all animals have, such as names, descriptions, colors, and state of adoption
 */
@Document(collection = "animal")
public abstract class Animal {

    /**
     * Default constructor for Animal object
     */
    public Animal() {
        name = "";
        description = "";
        color = "";
        state = new AvailableState();
    }

    /**
     * The string holding the name of the animal
     */
    @Id
    public String name;

    /**
     * The string holding the description of the animal
     */
    public String description;

    /**
     * The string holding the color of the animal
     */
    public String color;

    /**
     * The state object holding the adoption state of the animal
     */
    public State state;

    /**
     * The constructor for an animal object
     * @param _color the color of the animal
     * @param _description the description of the animal
     * @param _name the name of the animal
     * @param _state the state of the animal, for example available for adoption, on hold, or adopted
     */
    public void Animal(String _name, String _description, String _color, State _state) {
        name = _name;
        description = _description;
        color = _color;
        state = _state;
    }

    /**
     * Gets the name of the animal object
     * @return the name of the current animal object
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the animal object
     * @param _name the string to set the animal object's name to
     */
    public void setName(String _name) {
        name = _name;
    }

    /**
     * Gets the description of the animal object
     * @return the description of the current animal object
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the animal object
     * @param _description the string to set the animal object's name to
     */
    public void setDescription(String _description) {
        description = _description;
    }

    /**
     * Gets the state of the animal object
     * @return the state object of the current animal object
     */
    public State getState() { return state; }

    /**
     * Sets the updated state of the animal object
     * @param _state the state object to update the current animal object to
     */
    public void setState(State _state) {
        state = _state;
    }
    /**
     * Gets the color of the animal object
     * @return the color string of the current animal object
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the animal object
     * @param _color the color string of the current animal object
     */
    public void setColor(String _color) {
        color = _color;
    }
    /**
     * Method to change the state of the animal object from "available for adoption" to "on hold" to "adopted"
     */
    public void changeState() {
        this.state.changeState(this);
    }

}