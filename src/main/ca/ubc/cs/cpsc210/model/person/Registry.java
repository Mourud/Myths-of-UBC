package ca.ubc.cs.cpsc210.model.person;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Registry implements Iterable<Person> {
    List<Person> people;

    public Registry() {
        people = new ArrayList<>();
    }

    public boolean born(Person person) {
        return people.add(person);
    }


    public boolean die(Object o) {
        return people.remove(o);
    }

    public int population() {
        return people.size();
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }


    // TODO: Buff and nerf mechanisms
}
