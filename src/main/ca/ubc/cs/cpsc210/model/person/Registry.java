package ca.ubc.cs.cpsc210.model.person;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Registry implements Iterable<Person> {

    public Registry() {
        super();
    }



    public boolean add(Person person) {
        return population.add(person);
    }

    List<Person> population = new ArrayList<>();

    public boolean remove(Object o) {
        return population.remove(o);
    }

    public int size() {
        return population.size();
    }

    public boolean isEmpty() {
        return population.isEmpty();
    }

    public boolean contains(Object o) {
        return population.contains(o);
    }

    public Object[] toArray() {
        return population.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return population.toArray(a);
    }

    public boolean containsAll(Collection<?> c) {
        return population.containsAll(c);
    }

    public boolean addAll(Collection<? extends Person> c) {
        return population.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Person> c) {
        return population.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return population.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return population.retainAll(c);
    }

    public void replaceAll(UnaryOperator<Person> operator) {
        population.replaceAll(operator);
    }

    public void sort(Comparator<? super Person> c) {
        population.sort(c);
    }

    public void clear() {
        population.clear();
    }

    public Person get(int index) {
        return population.get(index);
    }

    public Person set(int index, Person element) {
        return population.set(index, element);
    }

    public int indexOf(Object o) {
        return population.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return population.lastIndexOf(o);
    }

    public ListIterator<Person> listIterator() {
        return population.listIterator();
    }

    public ListIterator<Person> listIterator(int index) {
        return population.listIterator(index);
    }

    public List<Person> subList(int fromIndex, int toIndex) {
        return population.subList(fromIndex, toIndex);
    }

    public boolean removeIf(Predicate<? super Person> filter) {
        return population.removeIf(filter);
    }

    public Stream<Person> stream() {
        return population.stream();
    }

    public Stream<Person> parallelStream() {
        return population.parallelStream();
    }

    @Override
    public Iterator<Person> iterator() {
        return population.iterator();
    }


    // TODO: Buff and nerf mechanisms
}
