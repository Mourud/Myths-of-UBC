package ca.ubc.cs.cpsc210.model.person;

import ca.ubc.cs.cpsc210.model.constants.GameConstants;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Registry implements Iterable<Person> {

    private static final int IS_IN_WAR = GameConstants.IS_IN_WAR_CODE;
    private static final int IS_IN_TOWN = GameConstants.IS_IN_TOWN_CODE;
    private static final int IS_OUT_OF_TOWN = GameConstants.IS_OUT_OF_TOWN_CODE;
    private static final int IS_IN_FARM = GameConstants.IS_IN_FARM_CODE;
    private static final int IS_IN_GOLD_MINE = GameConstants.IS_IN_GOLD_MINE_CODE;
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
//            int zone = p.getPersonGameZone();
//            switch (zone) {
//                case IS_IN_FARM:
//                    p.gatherResource("F");
//                case IS_IN_GOLD_MINE:
//                    p.gatherResource("G");
//                case IS_IN_TOWN:
//                    p.regenerate();
//                case IS_OUT_OF_TOWN:
//                    p.penalty();
//                    //case IS_IN_WAR: p.attack(null);
//
//            }
            p.setPos();
            p.updateLabel();
        }
    }
}
