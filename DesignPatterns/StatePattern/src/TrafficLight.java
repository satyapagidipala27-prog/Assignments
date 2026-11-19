public class TrafficLight {
    private State currentState;

    public TrafficLight() {
        currentState = new GreenState();
    }

    public void setState(State state) {
        if (state == null) {
            throw new IllegalArgumentException("Traffic light state cannot be null");
        }
        currentState = state;
    }

    public void changeSignal() {
        currentState.changeSignal(this);
    }
}
