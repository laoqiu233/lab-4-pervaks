package skills;

public interface Talkable {
    public class InCallException extends RuntimeException {
        public InCallException(Talkable t) {
            super(t + " is already in a call.");
        }
    }

    String toString();
    void say(String message, Talkable ...recipients);
    void call(Talkable target) throws InCallException;
    void endCall();
    Talkable getCallTarget();
}