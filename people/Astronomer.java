package people;
import cosmicobjects.CosmicObject;
import skills.Observer;
import world.City;
import world.PlanetDistances;

public final class Astronomer extends Person implements Observer {
    public Astronomer(String name, City city) {
        super(name, city);
    }

    public void observe(CosmicObject obj) {
        class Observation {
            CosmicObject target;

            Observation(CosmicObject target) {
                this.target = target;
            }

            String getObservationString() {
                if (target.getTargetPlanet() == null)
                    return "...it is currently standing still!";
                else {
                    return "It is travelling from " + target.getOrbitingPlanet() + " to " + target.getTargetPlanet() + " at a speed of " + target.getSpeed() + "m/s\n" +
                            "It will take " + target + ' ' + getTravelTime() + " seconds to reach its destination";
                }
            }

            long getTravelTime() {
                return Math.round(PlanetDistances.getDistance(target.getOrbitingPlanet(), target.getTargetPlanet()) / target.getSpeed());
            }
        }

        System.out.println(this + " observed a cosmic object in space " + obj);

        Observation obs = new Observation(obj);

        System.out.println(obs.getObservationString());

        System.out.println();
    }
}
