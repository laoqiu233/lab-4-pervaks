package world;
import java.util.HashMap;

public final class PlanetDistances {
    private static HashMap<Planet, HashMap<Planet, Double>> distances = new HashMap<>();

    static {
        for (Planet p : Planet.values()) 
            distances.put(p, new HashMap<>());
        
        //TODO: Put distances in seperate config file
        distances.get(Planet.EARTH).put(Planet.MOON, 384400000.0);
        distances.get(Planet.MOON).put(Planet.EARTH, 384400000.0);
    }

    private PlanetDistances() {}

    public static double getDistance(Planet a, Planet b) {
        if (PlanetDistances.distances.get(a).get(b) == null)
            return (a == b ? 0 : Double.POSITIVE_INFINITY);
        else
            return PlanetDistances.distances.get(a).get(b);
    }
}
