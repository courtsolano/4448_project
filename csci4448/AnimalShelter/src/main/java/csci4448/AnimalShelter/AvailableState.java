package csci4448.AnimalShelter;

/**
 * The state of an animal when it is available for adoption
 */
public class AvailableState implements State {

    /**
     * A method to change the state of an animal from Available to On Hold
     * @param a the animal to change the state of
     */
    @Override
    public void changeState(Animal a) {
        a.setState(new HoldState());
    }

    /**
     * A method that provides information on whether or not an animal should be shown on the animal list
     * @return true, because an animal that is available for adoption should be shown on the list of available animals
     */
    @Override
    public boolean shouldShow() {
        return true;
    }

    /**
     * A method that provides the string that describes the state of the animal on the animal list
     * @return the string "Available" because that is the current state of the animal
     */
    @Override
    public String getStateText() {
        return "Available";
    }
}
