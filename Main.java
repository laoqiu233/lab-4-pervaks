import cosmicobjects.SpaceShip;
import people.*;
import world.*;
import exceptions.*;

public class Main {
    public static void main(String[] args) {
        SpaceShip s = new SpaceShip("KOROTYSHKI", Planet.EARTH, 15000);

        for (int i=1; i<=6; i++) {
            try {
                s.addPerson(new Midget("Midget " + i, (i < 6 ? City.FLOWER_CITY : City.DAVILON)));
            } catch (UnreachableCityException e) {
                System.out.println(e.getMessage());
            }
        }

        Astronomer a1 = new Astronomer("Astronomer 1", City.DAVILON);
        Astronomer a2 = new Astronomer("Astronomer 2", City.DAVILON);

        Lord spruts = new Lord("Spruts", City.DAVILON);

        Commissioner ergigel = new Commissioner("Ergigel", City.DAVILON);

        a1.observe(s);

        Planet[] planets_to_test = {Planet.EARTH, Planet.VERY_FAR_PLANET, Planet.MOON};

        for (Planet p : planets_to_test) {
            try {
                s.startTravel(p);
            } catch (UnreachablePlanetException e) {
                System.out.println(e.getMessage());
            }
        }

        a2.observe(s);

        a2.say("We have observed a cosmic object moving towards the Moon from Earth", spruts);

        spruts.giveOrder("Continue your observation", a1, a2);

        spruts.call(ergigel);

        try {
            s.endTravel();
        } catch (BlackholeException e) {
            System.out.println("Midgets got sucked into a black hole and they have to travel again!");
            s.startTravel(Planet.MOON);
        }

        spruts.say("A ship full of midgets is arriving soon, we have to deal with it ASAP", ergigel);

        ergigel.say("All necessary measures will be taken", spruts);
        ergigel.say("We need to know the ETA of the ship, where there are landing and how many of them are there", spruts);
        ergigel.say("The information is necessary, so we could strike before they have the time to prepare", spruts);

        spruts.say("I will work on that, the information will be provided to you in time.", ergigel);

        spruts.endCall();
    }
}
