public class Customer {

    private State state = State.WAITING;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum State {
        WAITING,
        SERVED,
        LEFT
    }
}
