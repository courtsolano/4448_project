package csci4448.AnimalShelter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "volunteer")

/**
 * 
 */
public class Volunteer {

    /**
     * Default constructor
     */
    public Volunteer() {
        id = "";
        password = "";
        employeeId = 0;
    }

    /**
     * 
     */
    @Id
    private String id;
    // make a new user when changing and then clone and delete original username

    /**
     * 
     */
    private String password;

    /**
     *
     */
    private int employeeId;

    /**
     *
     */
    public Volunteer(String _username, String _password, int _employeeId) {
        id = _username;
        password = _password;
        employeeId = _employeeId;
    }

    /**
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param _password 
     * @return
     */
    public void setPassword(String _password) {
        password = _password;
    }

    /**
     * @return
     */
    public int getEmployeeId() {
        return employeeId;
    }


    /**
     * @param username 
     * @param password 
     * @return
     */
    public boolean login(String username, String password) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public void logout() {
        // TODO implement here
    }

    /**
     * @param _animal 
     * @return
     */
    public void addAnimal(Animal _animal) {
        // TODO implement here
    }

}