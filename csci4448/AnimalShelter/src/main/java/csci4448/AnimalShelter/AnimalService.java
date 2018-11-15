package csci4448.AnimalShelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class AnimalService {
    private final AnimalRepo animalRepo;
    private final AnimalFactory f = new AnimalFactory();

    @Autowired
    public AnimalService(AnimalRepo _animalRepo) {
        animalRepo = _animalRepo;
    }

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

    private long getCount() {
        return animalRepo.count();
    }

    public Animal getAnimal(String animalName) {
        Optional<Animal> a = animalRepo.findById(animalName);
        return a.orElse(null);
    }
}
