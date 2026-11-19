public class GreenState implements State {
    @Override
    public void changeSignal(TrafficLight trafficLight) {
        System.out.println("Green -> Yellow");
        trafficLight.setState(new YellowState());
    }
}
