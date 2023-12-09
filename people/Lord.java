package people;
import skills.*;
import world.City;

public class Lord extends Person {
    public Lord(String name, City city) {
        super(name, city);
    }

    public void giveOrder(String message, Talkable ...recipients) {
        for (Talkable p : recipients) {
            if (p instanceof Person)
                System.out.println(this + " gives an order to " + ((Person)p) + " : " + message);
        }

        System.out.println();
    }
}