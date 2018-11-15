package csci4448.AnimalShelter;

public class AnimalFactory {
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
