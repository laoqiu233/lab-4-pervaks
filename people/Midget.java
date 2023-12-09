package people;
import world.City;

public class Midget extends Person {
    public Midget(String name, City city) {
        super(name, city);
    }

    public void revolt() {
        System.out.println(this + " is now revolting in " + this.getCity() + '\n');
    }
}
