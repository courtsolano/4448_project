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
	public void create(UserService userService) {
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome! Enter your name");
			String volunteerName = input.nextLine();
			System.out.println("Enter your password");
			String volunteerpass = input.nextLine();
			if (!userService.userSignUp(volunteerName, volunteerpass)){
				System.out.println("Username already taken.");
				continue;
			}
			Volunteer v = userService.getUser(volunteerName);
			System.out.println("Welcome, " + v.getId());
			return;
		}
//		Dog d = new Dog();
//		d.setActivityLevel(10);
//		System.out.println("activity level: " + d.getActivityLevel());
	}
}