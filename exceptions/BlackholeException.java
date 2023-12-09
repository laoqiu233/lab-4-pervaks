package exceptions;

import cosmicobjects.SpaceShip;

public class BlackholeException extends Exception {
    public BlackholeException(SpaceShip s) {
        super(s + " got sucked into a black hole during travel and returned to it's origin planet");
    }
}
