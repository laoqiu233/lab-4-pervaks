package exceptions;

import cosmicobjects.SpaceShip;
import people.Person;
import world.City;

public class UnreachableCityException extends RuntimeException {
    public UnreachableCityException(SpaceShip s, Person p) {
        super(p + " can't board " + s + " because they are on different planets.");
    }

    public UnreachableCityException(SpaceShip s, City c) {
        super(s + " can't discard its crew to " + c + " because they are on different planets.");
    }
}