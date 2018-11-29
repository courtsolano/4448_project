package csci4448.AnimalShelter;

import java.util.List;
import java.util.Scanner;

/**
 * The class implementing the menu functionality of the application
 */
public class Menu {
    /**
     * A boolean value that stores whether or not a user is logged in
     */
    private boolean loggedIn;

    /**
     * The default menu string that is shown to a user that is not logged in
     */
    private final String defaultMenu = "Welcome! Select an option:\n1. Browse Animals\n2. Log in\n3. Sign up\n4. Exit";

    /**
     * The string that stores the user input for the main menu options
     */
    private String userOption;

    /**
     * The default volunteer that is populated when a user logs in
     */
    public Volunteer v;

    /**
     * The default constructor for the menu object
     */
    public Menu() {
        loggedIn = false;
    }

    /**
     * The constructor for the menu object that takes in whether or not a user is logged in
     * @param _loggedIn a boolean value that stores if a user is logged in
     */
    public Menu(boolean _loggedIn){
        loggedIn = _loggedIn;
    }

    /**
     * Gets the value of loggedIn, which is true if the user is logged in, and false otherwise
     * @return a boolean value specifying if the user is logged in or not
     */
    public boolean getLoggedIn(){
        return loggedIn;
    }

    /**
     * Sets the value of the loggedIn variable
     * @param _loggedIn true if the user is logged in, false otherwise
     */
    public void setLoggedIn(boolean _loggedIn) {
        loggedIn = _loggedIn;
    }

    /**
     * Gets the option the user selected from the menu
     * @return the value of the user inputted option for the menu
     */
    public String getUserOption(){
        return userOption;
    }

    /**
     * Sets the option that the user selected from the menu
     * @param _userOption the string from user input
     */
    public void setUserOption(String _userOption) {
        userOption = _userOption;
    }

    /**
     * A method to print the menu without a volunteer parameter
     * @return the default menu string variable
     */
    public String printMenu() {
        return (defaultMenu);
    }

    /**
     * A method to print the menu with a volunteer parameter, returns the default menu if the user is not logged in
     * and the custom menu if a user is logged in
     * @param v the volunteer object that is currently logged in
     * @return the string menu corresponding to whether or not a user is logged in
     */
    public String printMenu(Volunteer v) {
        if (this.loggedIn) {
            return ("Welcome, " + v.getId() + ".\n1. Add an animal\n2. Update password\n3. Log out\n");
        }
        return (defaultMenu);
    }

    /**
     * A method that provides the functionality for the user input after the menu is displayed
     * @param animalService the animal database object
     * @param input the user input Scanner object
     * @param userService the user database object
     */
    public void userControls(Scanner input, UserService userService, AnimalService animalService) {
        if (!loggedIn) {
            if (this.userOption.equals("1")) {
                System.out.println("Here are the available animals:");
                List<Animal> l = animalService.getAllAnimals();
                for (Animal a : l) {
                    if (a.getState().shouldShow()) {
                        System.out.println(a.getName() + " : " + a.getState().getStateText());
                    }
                }
                adoptAnimal(input, animalService);
            }
            else if (this.userOption.equals("2")) {
                if (userLogIn(input, userService)) {
                    this.setLoggedIn(true);
                }
            }
            else if (this.userOption.equals("3")) {
                String volunteerName = userSignUp(input, userService);
                v = userService.getUser(volunteerName).orElse(null);
                if (v == null) {
                    return;
                }
                this.setLoggedIn(true);
            }
            else if (this.userOption.equals("4")) {
                System.out.println("Exiting...");
                System.exit(0);
            }
            else {
                System.out.println("Command not understood.");
            }
        }
        else {
            if (this.userOption.equals("1")) {
                System.out.println("Here is where you add an animal!");
                String animalName = addAnimal(input, animalService);
                System.out.println("Added " + animalName + " to database!");
            }
            else if (this.userOption.equals("2")) {
                userUpdatePassword(input, userService, v);
                System.out.println("Password updated.");
            }
            else if (this.userOption.equals("3")) {
                System.out.println("Logging out...");
                setLoggedIn(false);
            }
        }
    }

    /**
     * The functionality for a user to add an animal to the database
     * @param input the user input scanner object needed for getting user input
     * @param animalService the animal database object needed for storing the animal in the database
     * @return the animal type that was added
     */
    private String addAnimal(Scanner input, AnimalService animalService) {
        System.out.println("Enter an animal type: ");
        String animalType = input.nextLine();
        if (!animalService.addAnimal(animalType, input)){
            System.out.println("Animal already added.");
        }
        return animalType;
    }

    /**
     * A method to allow a user to create an account stored in the database
     * @param input the user input scanner object needed for getting user input
     * @param userService the user database object needed for storing the user in the database
     * @return the name of the volunteer that a user tries to add
     */
    private String userSignUp(Scanner input, UserService userService) {
        System.out.println("Enter a username: ");
        String volunteerName = input.nextLine();
        System.out.println("Enter a password: ");
        String volunteerPass = input.nextLine();
        if (!userService.userSignUp(volunteerName, volunteerPass)){
            System.out.println("Username already taken.");
        }
        return volunteerName;
    }

    /**
     * A method for a user to log in to their account
     * @param userService the user database needed for searching for a user in the database
     * @param input the user input scanner object needed for getting user input
     * @return a boolean value determining whether or not a user was able to log in to their account
     */
    private boolean userLogIn(Scanner input, UserService userService) {
        System.out.println("Enter your username: ");
        String username = input.nextLine();
        v = userService.getUser(username).orElse(null);
        if (v == null) {
            System.out.println("Username not found. Try again.");
            return false;
        }
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        if (!v.getPassword().equals(password)) {
            System.out.println("Incorrect password. Try again.");
            v = null;
            return false;
        }
        return true;
    }

    /**
     * A method for a user to update their password
     * @param input the user input scanner object needed for getting user input
     * @param userService the user database object needed for updating the password in the database
     * @param v the volunteer to update the password for;
     */
    private void userUpdatePassword(Scanner input, UserService userService, Volunteer v) {
        System.out.println("Enter your new password: ");
        String newPassword = input.nextLine();
        v.setPassword(newPassword);
        userService.saveUser(v);
    }

    /**
     * A method to adopt an animal, including printing status to the user
     * @param input the user input scanner object needed for getting user input
     * @param animalService the animal database object needed for retrieving the animal from and saving it to the database
     */
    private void adoptAnimal(Scanner input, AnimalService animalService) {
        System.out.println("Enter the name of the animal you wish to adopt, or enter exit to return to the main menu.");
        String userInput = input.nextLine();
        if (userInput.equals("exit")) {
            return;
        }
        else if (animalService.getAnimal(userInput) == null) {
            System.out.println("That animal is not available.");
            return;
        }
        Animal a = animalService.getAnimal(userInput);
        if (a.getState() instanceof AdoptedState) {
            System.out.println("That animal is not available.");
            return;
        }
        a.getState().changeState(a);
        animalService.saveAnimal(a);

        System.out.println(a.getName() + " is now " + a.getState().getStateText() + "!");
    }
}
