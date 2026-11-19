public class RedState implements State {
    @Override
    public void changeSignal(TrafficLight trafficLight) {
        System.out.println("Red -> Green");
        trafficLight.setState(new GreenState());
    }
}
