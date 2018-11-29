package csci4448.AnimalShelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Scanner;

/**
 * This is the main application where the program is run
 */
@SpringBootApplication
public class AnimalShelterApplication {

	/**
	 * Main function for the application
	 * @param args Array of strings for arguments of the main function, this typically will be empty
	 */
	public static void main(String[] args) {
		SpringApplication.run(AnimalShelterApplication.class, args);
	}
}

/**
 * Driver contains the shell portion of the application and is called from main
 */
@ShellComponent
class driver {

	/**
	 * Creates a shell for the main function
	 * @param userService The service connecting the application to the user collection of the database
	 * @param animalService The service connecting the application to the animal collection of the database
	 */
	@Autowired
	@ShellMethod("Driver")
	public void create(UserService userService, AnimalService animalService) {
		Menu m = new Menu();
		Scanner input = new Scanner(System.in);
		while(true) {
			while (m.getLoggedIn()) {
				Volunteer v = m.v;
				System.out.println(m.printMenu(v));
				String option = input.nextLine();
				m.setUserOption(option);
				m.userControls(input, userService, animalService);
			}
			System.out.println(m.printMenu());
			String option = input.nextLine();
			m.setUserOption(option);
 			m.userControls(input, userService, animalService);
		}
	}
}