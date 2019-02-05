package ca.ubc.cs.cpsc210.model.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Population implements Iterable<Person> {
    List<Person> population = new ArrayList<>();

    @Override
    public Iterator<Person> iterator() {
        return population.iterator();
    }
    // TODO: Buff and nerf mechanisms
    // TODO: Make seperate army and civilians list?
}
