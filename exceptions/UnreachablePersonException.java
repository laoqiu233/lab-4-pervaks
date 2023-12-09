package exceptions;

import people.Person;

public class UnreachablePersonException extends RuntimeException {
    public UnreachablePersonException(Person p1, Person p2) {
        super(p1 + "can't directly reach " + p2 + " since they are in different cities.");
    }
}
