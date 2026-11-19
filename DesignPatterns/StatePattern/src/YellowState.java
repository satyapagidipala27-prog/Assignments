public class YellowState implements State {
    @Override
    public void changeSignal(TrafficLight trafficLight) {
        System.out.println("Yellow -> Red");
        trafficLight.setState(new RedState());
    }
}
