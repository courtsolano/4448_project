package csci4448.AnimalShelter;

/**
 * The state of an animal when it is on hold by a customer
 */
public class HoldState implements State {

    /**
     * Changes the animal's state from Adopted to On Hold
     * @param a the animal who's state is being changed
     */
    @Override
    public void changeState(Animal a) {
        a.setState(new AdoptedState());
    }

    /**
     * Provides information on whether or not the animal should show on the animal list shown to users
     * @return true, because an animal on hold should still be shown to the user in case they become available again
     */
    @Override
    public boolean shouldShow() {
        return true;
    }

    /**
     * A method that provides the text to be shown next to the animal on the animal list shown to users
     * @return the string "On Hold" because that is the current state of the animal
     */
    @Override
    public String getStateText() {
        return "On Hold";
    }
}
