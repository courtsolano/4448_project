package csci4448.AnimalShelter;

import java.util.*;

/**
 * 
 */
public abstract class Animal {

    /**
     * Default constructor
     */
    public Animal() {
    }

    /**
     * 
     */
    public int animalId;

    /**
     * 
     */
    public String name;

    /**
     * 
     */
    public String image;

    /**
     * 
     */
    public String color;

    /**
     * @return
     */
    public void Animal() {
        animalId = 0;
        name = "";
        image = "";
        color = "";
        return;
    }

    /**
     * @return
     */
    public void setAnimalId(int _animalId) {
        animalId = _animalId;
        return;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param _name 
     * @return
     */
    public void setName(String _name) {
        name = _name;
        return;
    }

    /**
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     * @param _image 
     * @return
     */
    public void setImage(String _image) {
        image = _image;
        return;
    }

    /**
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * @param _color 
     * @return
     */
    public void setColor(String _color) {
        color = _color;
        return;
    }

    /**
     * @param animalId 
     * @return
     */
    public boolean becomeAdopted(int animalId) {
        // TODO implement here
        return false;
    }

}