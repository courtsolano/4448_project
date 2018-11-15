package csci4448.AnimalShelter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "animal")

public abstract class Animal {

    /**
     * Default constructor
     */
    public Animal() {
        name = "";
        description = "";
        color = "";
        adopted = false;
    }

    /**
     * 
     */
    @Id
    public String name;

    /**
     * 
     */
    public String description;

    /**
     * 
     */
    public String color;

    public boolean adopted;

    /**
     *
     */
    public void Animal(String _name, String _description, String _color, boolean _adopted) {
        name = _name;
        description = _description;
        color = _color;
        adopted = _adopted;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param _name name
     */
    public void setName(String _name) {
        name = _name;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param _description description
     */
    public void setDescription(String _description) {
        description = _description;
    }

    public boolean getAdopted() { return adopted; }

    public void setAdopted(boolean _adopted) {
        adopted = _adopted;
    }
    /**
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param _color color
     */
    public void setColor(String _color) {
        color = _color;
    }

}