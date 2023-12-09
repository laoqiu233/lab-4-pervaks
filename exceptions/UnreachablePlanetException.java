package exceptions;

import cosmicobjects.SpaceShip;
import world.Planet;

public class UnreachablePlanetException extends RuntimeException {
    public UnreachablePlanetException(SpaceShip s) {
        super(s + " is already orbiting the target planet.");
    }

    public UnreachablePlanetException(SpaceShip s, Planet t) {
        super(t + " is too far away for " + s + " to reach.");
    }

    public UnreachablePlanetException(SpaceShip s, double max_speed) {
        super(s + "can't escape " + s.getOrbitingPlanet() + 
              "because its maximum speed " + max_speed + 
              "is less than the required escape velocity of " + s.getOrbitingPlanet().escapeVelocity());
    }
}
