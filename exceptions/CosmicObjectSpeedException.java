package exceptions;

public class CosmicObjectSpeedException extends RuntimeException {
    public CosmicObjectSpeedException() {
        super("Cosmic objects cannot have negative speed");
    }

    public CosmicObjectSpeedException(double max_speed) {
        super("Cosmic object is trying to accelerate over maximum speed of " + max_speed);
    }
}
