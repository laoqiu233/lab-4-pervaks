package cosmicobjects;
import java.util.ArrayList;

import people.Person;
import skills.Carriable;
import world.City;
import world.Planet;
import world.PlanetDistances;
import exceptions.*;

import java.util.Random;

public class SpaceShip extends CosmicObject implements Carriable {
    private ArrayList<Person> crew = new ArrayList<Person>();
    private String name;

    public SpaceShip(String name, Planet orbiting_planet) {
        this.name = name;
        setOrbitingPlanet(orbiting_planet);
    }

    public SpaceShip(String name, Planet orbiting_planet, double max_speed) {
        this.name = name;
        setOrbitingPlanet(orbiting_planet);
        this.max_speed = max_speed;
    }
    
    public String toString() {
        return "SpaceShip \"" + name + "\" with " + crew.size() + " passenger(s) @ " + getOrbitingPlanet().toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpaceShip)) return false;

        SpaceShip s = (SpaceShip)o;

        return this.name == s.name &&
               getSpeed() == s.getSpeed() &&
               this.getTargetPlanet() == s.getTargetPlanet() && 
               this.getOrbitingPlanet() == s.getOrbitingPlanet() &&
               this.crew.equals(s.crew);
    }

    public int hashCode() {
        int hash = (this.name + getSpeed() + this.getTargetPlanet() + this.getOrbitingPlanet()).hashCode();

        for (Person p : this.crew) hash += p.hashCode();

        return hash;
    }

    @Override
    public void addPerson(Person p) throws UnreachableCityException {
        if (p.getCity().getPlanet() == getOrbitingPlanet()) {
            crew.add(p);
            System.out.println(p + " has boarded " + this + '\n');
        } else {
            throw new UnreachableCityException(this, p);
        }
    }

    public ArrayList<Person> getCrew() {
        return crew;
    }

    public void discardCrew(City city) throws UnreachableCityException {
        if (city.getPlanet() == getOrbitingPlanet()) {
            System.out.println(this + " is discrading its crew to " + city);
            for (Person p : crew) p.setCity(city);
            this.crew.clear();
        } else {
            throw new UnreachableCityException(this, city);
        }
    }

    public void startTravel(Planet p) {
        System.out.println(this + " is trying to move to planet " + p + "...");

        if (getOrbitingPlanet() == p) {
            throw new UnreachablePlanetException(this);
        } else {
            if (Double.isInfinite(PlanetDistances.getDistance(getOrbitingPlanet(), p)))
                throw new UnreachablePlanetException(this, p);
            
            try {
                setSpeed(getOrbitingPlanet().escapeVelocity());
            } catch (CosmicObjectSpeedException e) {
                throw new UnreachablePlanetException(this, this.getMaxSpeed());
            }
            setTargetPlanet(p);
            System.out.println(this + " is traveling towards " + p);
        }

        System.out.println();
    }

    public void endTravel() throws BlackholeException {
        if (getTargetPlanet() == null) return;

        if (new Random().nextDouble() < 0.1) {
            setSpeed(0);
            setTargetPlanet(null);
            throw new BlackholeException(this);
        };

        System.out.println(this + " is approaching " + getTargetPlanet() + "s orbit!");
        
        setSpeed(0);

        setOrbitingPlanet(getTargetPlanet());
        setTargetPlanet(null);

        System.out.println();
    }
}