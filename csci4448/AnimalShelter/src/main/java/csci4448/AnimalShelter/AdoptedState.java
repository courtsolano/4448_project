package csci4448.AnimalShelter;

/**
 * The state of an animal when it has been adopted
 */
public class AdoptedState implements State {
    /**
     * Changes the state from Adopted to Available
     * @param a the animal object to change the state for
     */
    @Override
    public void changeState(Animal a) {
        a.setState(new AvailableState());
    }

    /**
     * Method that returns whether or not an animal should show in the animal list
     * @return false because the animal is adopted, and therefore not available
     */
    @Override
    public boolean shouldShow() {
        return false;
    }

    /**
     * Method that returns the text of the state of the animal for showing in the animal list
     * @return the string "Adopted", because the animal is now adopted
     */
    @Override
    public String getStateText() {
        return "Adopted";
    }
}
