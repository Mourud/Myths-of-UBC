package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;

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

    public boolean isExtinct() {
        return people.size() == 0;
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }


    public void update() {
        for (Person p : people) {
            p.setPos();
            p.updateLabel();
        }
    }

    private class RegistryIterator implements Iterator<Person> {

        public RegistryIterator(){

        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Person next() {
            return null;
        }

    }
}
