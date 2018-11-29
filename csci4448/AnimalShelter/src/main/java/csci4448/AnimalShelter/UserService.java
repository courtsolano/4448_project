package csci4448.AnimalShelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * Service creating the user collection of the database and connecting it to the application
 */
@Service
public class UserService {

    /**
     * The repository object for the user repository
     */
    private final UserRepo repo;

    /**
     * Default constructor for the user service object
     * @param _repo the parameter for the repository object
     */
    @Autowired
    public UserService(UserRepo _repo) {
        repo = _repo;
    }

    /**
     * Method that adds new users to a database if they have a unique username
     * @param username the username from user input for signing up
     * @param password the password from user input for signing up
     * @return true if the user is able to be created and saved, false if not
     */
    public boolean userSignUp(String username, String password) {
        if (getUser(username) != null) {
            return false;
        }
        Volunteer v = new Volunteer(username, password);
        saveUser(v);
        return true;
    }

    /**
     * Adds the new user to the mongodb user repository
     * @param v holds the new volunteer object
     */
    public void saveUser(Volunteer v) {
        repo.save(v);
    }

    /**
     * Finds a user in a database by their username
     * @param username the unique username of a user to find in the database
     * @return an optional volunteer object, for example a found user if one exists or nothing if the user does not
     */
    public Optional<Volunteer> getUser(String username) {
        return repo.findById(username);
    }
}
