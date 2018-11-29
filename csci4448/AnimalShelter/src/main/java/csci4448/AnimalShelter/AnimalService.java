package csci4448.AnimalShelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Sets up a database object for the menu to be able to add/view/update animals through the animal service
 */
@Service
public class AnimalService {

    /**
     * The animal repository object
     */
    private final AnimalRepo animalRepo;

    /**
     * The animal factory object that will be used to create new animals
     */
    private final AnimalFactory f = new AnimalFactory();

    /**
     * The constructor for the animal service that sets the animal repository
     * @param _animalRepo the repository used to store an animal in the animal database
     */
    @Autowired
    public AnimalService(AnimalRepo _animalRepo) {
        animalRepo = _animalRepo;
    }

    /**
     * A method to add a new animal to the database
     * @param animalType the type of animal the user wants to add
     * @param input the scanner object used to get input from the user
     * @return a boolean value that stores whether or not the animal was successfully added to the database
     */
    public boolean addAnimal(String animalType, Scanner input) {
        Animal a;
        System.out.println("Enter the animal's name: ");
        String name = input.nextLine();
        System.out.println("Enter the animal's description: ");
        String description = input.nextLine();
        System.out.println("Enter the animal's color: ");
        String color = input.nextLine();
        a = f.getAnimal(animalType);
        if (a != null) {
            a.setName(name);
            a.setColor(color);
            a.setDescription(description);
            if (a instanceof Dog) {
                System.out.println("Enter the dog's activity level: ");
                String activityLevel = input.nextLine();
                ((Dog) a).setActivityLevel(Integer.parseInt(activityLevel));
            }
            else if (a instanceof Fish) {
                System.out.println("Enter the fish's water type: ");
                String waterType = input.nextLine();
                ((Fish) a).setWaterType(waterType);
            }
            else if (a instanceof Turtle) {
                System.out.println("Enter the turtle's type: ");
                String turtleType = input.nextLine();
                ((Turtle) a).setType(turtleType);
            }
        }
        else {
            System.out.println("That type of animal is not welcome at the shelter. Please add a Dog, Fish, or Turtle.");
            return false;
        }
        animalRepo.save(a);
        return true;
    }

    /**
     * A method that gets the number of animals in the database
     * @return The number of animals in the database
     */
    private long getCount() {
        return animalRepo.count();
    }

    /**
     * A method that gets an animal by it's unique name
     * @param animalName The name of an animal to find in the database
     * @return Either an animal object or null if the animal is not found
     */
    public Animal getAnimal(String animalName) {
        Optional<Animal> a = animalRepo.findById(animalName);
        return a.orElse(null);
    }

    /**
     * A method that gets a list of all of the animals in the database
     * @return The list of all animals in the database
     */
    public List<Animal> getAllAnimals() {
        return animalRepo.findAll();
    }

    /**
     * A method that saves an animal to the database
     * @param a The animal to save to the database
     */
    public void saveAnimal(Animal a){
        animalRepo.save(a);
    }
}
