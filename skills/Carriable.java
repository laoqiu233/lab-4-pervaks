package skills;
import java.util.ArrayList;
import people.Person;
import world.City;
import exceptions.UnreachableCityException;

public interface Carriable {
    void addPerson(Person p) throws UnreachableCityException;
    ArrayList<Person> getCrew();
    void discardCrew(City city) throws UnreachableCityException;
}