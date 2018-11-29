package csci4448.AnimalShelter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * The class containing the methods for a volunteer which is a user in this system
 */
@Document(collection = "volunteer")
public class Volunteer {

    /**
     * Default constructor for a volunteer object
     */
    public Volunteer() {
        id = "";
        password = "";
    }

    /**
     * The username and unique identifier for a volunteer
     */
    @Id
    private String id;

    /**
     * The password for the volunteer
     */
    private String password;

    /**
     * The constructor for a volunteer object
     * @param _id the identification for the current user
     * @param _password the password corresponding to the identification of the current user
     */
    public Volunteer(String _id, String _password) {
        id = _id;
        password = _password;
    }

    /**
     * Gets the volunteer id for a volunteer object
     * @return the volunteer id for the current volunteer
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the password for a volunteer object
     * @return password for the current volunteer
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the volunteer id for a volunteer object
     * @param _id an updated unique id for a user
     */
    public void setId(String _id) { id = _id; }

    /**
     * Sets the password for a volunteer
     * @param _password an updated value for a user's password
     */
    public void setPassword(String _password) {
        password = _password;
    }
}