package csci4448.AnimalShelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Scanner;

@SpringBootApplication
public class AnimalShelterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalShelterApplication.class, args);
	}
}

@ShellComponent
class driver {
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