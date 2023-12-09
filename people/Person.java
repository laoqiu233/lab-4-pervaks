package people;

import exceptions.UnreachablePersonException;
import skills.Locatable;
import skills.Talkable;
import world.City;

public class Person implements Talkable, Locatable {
    private final String name;
    private City city;
    private CallConnection conn;

    private abstract class CallConnection {
        Talkable target;

        public CallConnection(Talkable target) {
            this.target = target;
        }

        abstract void say(String message);
    }
    
    public Person(String name, City city) {
        this.name = name;
        this.city = city; 
    }

    public String toString() {
        return this.getClass().getSimpleName() + ' ' + name + " @ " + city;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;

        Person p = (Person)o;

        return this.name == p.name &&
               this.city == p.city;
    }

    public int hashCode() {
        return this.getClass().getName().hashCode() + this.name.hashCode() + this.city.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setCity(City city) {
        this.city = city;
        System.out.println(this + " is now located at " + city);
        System.out.println();
    }

    public City getCity() {
        return city;
    }

    public void say(String message, Talkable ...recipients) {
        for (Talkable p : recipients) {
            // Сначало проверяем на доступность, т.к. может существовать существо 
            // которое находится везде и можно с ним везде разговаривать.

            if (p == getCallTarget()) conn.say(message);
            else if (p instanceof Locatable && ((Locatable)p).getCity() != this.getCity())
                throw new UnreachablePersonException(this, (Person)p);
            else System.out.println(this + " says to " + p + " : " + message);
        }

        System.out.println();
    }

    public void call(Talkable target) {
        if (this.getCallTarget() != null) throw new Talkable.InCallException(this);
        if (target.getCallTarget() != null && target.getCallTarget() != this) throw new Talkable.InCallException(target);

        conn = new CallConnection(target) {
            void say(String message) {
                System.out.println(Person.this + " says to " + target + " over the phone: " + message);
            }
        };

        if (target.getCallTarget() == null) {
            System.out.println(this + " establishes a phone connection with " + target + '\n');
            target.call(this);
        }
    }

    public void endCall() {
        if (getCallTarget() != null) {
            CallConnection temp = conn;
            conn = null;

            if (temp.target.getCallTarget() != null) {
                System.out.println(this + " closes a phone connection with " + temp.target);
                temp.target.endCall();
            }
        }
    }

    public Talkable getCallTarget() {
        if (conn == null) return null;
        else return conn.target;
    }
}