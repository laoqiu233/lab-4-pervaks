package cosmicobjects;
import exceptions.BlackholeException;
import exceptions.CosmicObjectSpeedException;
import world.Planet;

public abstract class CosmicObject {
    private Planet orbitingPlanet;
    private Planet targetPlanet;
    private double speed;
    protected double max_speed = 300000000;

    public abstract String toString();
    public abstract boolean equals(Object o);

    public double getSpeed() {
        return speed;
    }

    protected void setSpeed(double speed) {
        if (speed < 0) throw new CosmicObjectSpeedException();
        else if (speed > max_speed) throw new CosmicObjectSpeedException(speed);

        if (this.speed < speed) {
            System.out.println(this + " is increasing its speed by " + (speed - this.speed) + " m/s");
        } else if (this.speed < speed) {
            System.out.println(this + " is decreasing its speed by " + (this.speed - speed) + " m/s");
        }

        this.speed = speed;

        System.out.println(this + " is moving at " + getSpeed() + " m/s");
    }

    public double getMaxSpeed() {
        return max_speed;
    }

    public Planet getTargetPlanet() {
        return targetPlanet;
    }

    protected void setTargetPlanet(Planet p) {
        targetPlanet = p;
    }

    abstract void startTravel(Planet p);
    abstract void endTravel() throws BlackholeException;

    public Planet getOrbitingPlanet() {
        return orbitingPlanet;
    }

    protected void setOrbitingPlanet(Planet orbitingPlanet) {
        this.orbitingPlanet = orbitingPlanet;
        System.out.println(this + " is now orbiting " + orbitingPlanet);
        System.out.println();
    }
}