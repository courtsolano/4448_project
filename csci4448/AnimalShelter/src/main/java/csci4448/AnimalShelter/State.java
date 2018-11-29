package csci4448.AnimalShelter;

/**
 * An interface for the state of an animal
 */
interface State {

    /**
     * A method to change the state of an animal
     * @param a the animal to change the state for
     */
    public void changeState(Animal a);

    /**
     * A method to determine if an animal should show on the animal list shown to the user
     * @return true if the animal should be shown, false otherwise
     */
    public boolean shouldShow();

    /**
     * A method to get the text of the current state the animal is in
     * @return A string that is either "Available", "On Hold", or "" depending on the state of the animal
     */
    public String getStateText();
}