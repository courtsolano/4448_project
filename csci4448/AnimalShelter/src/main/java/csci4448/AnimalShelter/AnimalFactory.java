package csci4448.AnimalShelter;

/**
 * A failed implementation of a factory for animals, that is still used to create an instance of a type of animal
 */
public class AnimalFactory {

    /**
     * A class that returns a new instance of a subclass of animals depending on the animalType specified
     * @param animalType the string holding the type of animal the user wants to create
     * @return a new animal of type specified if the type is valid, null otherwise
     */
    public Animal getAnimal(String animalType){
        if (animalType == null) {
            return null;
        }
        if(animalType.equalsIgnoreCase("DOG")) {
            return new Dog();
        }
        else if(animalType.equalsIgnoreCase("TURTLE")) {
            return new Turtle();
        }
        else if(animalType.equalsIgnoreCase("FISH")) {
            return new Fish();
        }
        return null;
    }
}
