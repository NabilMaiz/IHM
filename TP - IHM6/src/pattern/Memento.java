package pattern;


public class Memento {

    private String state;

    public Memento(String stateToSave) {
        this.state = state;
    }

    public String getSavedState() {
        return state;
    }

}
