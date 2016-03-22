package pattern;


import java.util.ArrayList;

public class Caretaker {

    private ArrayList<Memento> savedMementos = new ArrayList<>();

    public void addMemnto(Memento toSave)
    {
        this.savedMementos.add(toSave);
    }

    public Memento getMemento(int index)
    {
        return  savedMementos.get(index);
    }

}
