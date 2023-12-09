package world;

public enum City {
    FLOWER_CITY(Planet.EARTH),
    GREEN_CITY(Planet.EARTH),
    SUN_CITY(Planet.EARTH),

    DAVILON(Planet.MOON),
    GRABENBURG(Planet.MOON),
    BREKHENVILLE(Planet.MOON),
    SAN_KOMARAK(Planet.MOON),
    LOS_SWINOS(Planet.MOON),
    FANTOMAS(Planet.MOON);

    private Planet planet;

    private City(Planet planet) {
        this.planet = planet;
    }

    public Planet getPlanet() {
        return this.planet;
    }

    public String toString() {
        return this.name() + " of planet " + this.planet;
    }
}
