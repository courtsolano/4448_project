package csci4448.AnimalShelter;

import java.util.Scanner;

public class Menu {

    private boolean loggedIn;
    private final String defaultMenu = "Welcome! Select an option:\n1. Browse Animals\n2. Log in\n3. Sign up\n4. Exit";
    private String userOption;
    public Volunteer v;

    public Menu() {
        loggedIn = false;
    }

    public Menu(boolean _loggedIn){
        loggedIn = _loggedIn;
    }

    public boolean getLoggedIn(){
        return loggedIn;
    }

    public void setLoggedIn(boolean _loggedIn) {
        loggedIn = _loggedIn;
    }

    public String getUserOption(){
        return userOption;
    }

    public void setUserOption(String _userOption) {
        userOption = _userOption;
    }

    public String printMenu() {
        return (defaultMenu);
    }

    public String printMenu(Volunteer v) {
        if (this.loggedIn) {
            return ("Welcome, " + v.getId() + ".\n1. Add an animal\n2. Update password\n3. Log out\n");
        }
        return (defaultMenu);
    }

    public void userControls(Scanner input, UserService userService, AnimalService animalService) {
        if (!loggedIn) {
            if (this.userOption.equals("1")) {
                System.out.println("Here are the available animals:");
            }
            else if (this.userOption.equals("2")) {
                if (userLogIn(input, userService)) {
                    this.setLoggedIn(true);
                }
            }
            else if (this.userOption.equals("3")) {
                String volunteerName = userSignUp(input, userService);
//                v = userService.getUser(volunteerName);
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
                System.out.println("Here is where you would add an animal...");
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

    private String addAnimal(Scanner input, AnimalService animalService) {
        System.out.println("Enter an animal type: ");
        String animalType = input.nextLine();
        if (!animalService.addAnimal(animalType, input)){
            System.out.println("Animal already added.");
        }
        return animalType;
    }

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

    private void userUpdatePassword(Scanner input, UserService userService, Volunteer v) {
            System.out.println("Enter your new password: ");
            String newPassword = input.nextLine();
            v.setPassword(newPassword);
            userService.saveUser(v);
        }
}
