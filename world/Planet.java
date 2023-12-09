package world;

public enum Planet {
    EARTH(11190.0),
    MOON(2380.0),
    VERY_FAR_PLANET(100.0);

    private final double escape_velocity;

    private Planet(double escape_velocity) {
        this.escape_velocity = escape_velocity;
    }

    public double escapeVelocity() {
        return escape_velocity;
    }
}