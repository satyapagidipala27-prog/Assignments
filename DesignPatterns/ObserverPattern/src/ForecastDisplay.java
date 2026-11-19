public class ForecastDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Forecast Display:");

        if (pressure > 1015) {
            System.out.println("Weather looks good!");
        } else if (pressure < 1000) {
            System.out.println("Rainy weather expected!");
        } else {
            System.out.println("Weather conditions may change.");
        }

        System.out.println("-------------------");
    }
}
